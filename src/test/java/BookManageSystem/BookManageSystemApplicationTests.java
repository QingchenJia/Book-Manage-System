package BookManageSystem;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.*;
import BookManageSystem.pojo.resp.data.BookOverview;
import BookManageSystem.pojo.resp.data.BookSearch;
import BookManageSystem.pojo.resp.data.BorrowHistory;
import BookManageSystem.pojo.resp.data.BorrowInfo;
import BookManageSystem.service.BookInfoService;
import BookManageSystem.service.BorrowService;
import BookManageSystem.utils.CipherUtil;
import BookManageSystem.utils.JSONUtil;
import BookManageSystem.utils.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@SpringBootTest
class BookManageSystemApplicationTests {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookTypeMapper bookTypeMapper;
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BorrowMapper borrowMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelectAllBookInfo() {
        List<BookInfo> bookInfos = bookInfoMapper.selectAll();
        bookInfos.forEach(System.out::println);
    }

    @Test
    void testSelectAllBookType() {
        List<BookType> bookTypes = bookTypeMapper.selectAll();
        bookTypes.forEach(System.out::println);
    }

    @Test
    void testJSONUtil() {
        Admin admin = new Admin("admin", "123456");
        String json = JSONUtil.object2JSON(admin);
        System.out.println(json);

        Admin o = (Admin) JSONUtil.JSON2object(json, Admin.class);
        System.out.println(o);
    }

    @Test
    void testBookInfoSelectAllService() {
        System.out.println(bookInfoService.queryAllBook());
    }

    @Test
    void testGenerateToken() {
        User user = new User();
        user.setUid("U101");
        user.setPasswd("123456");

        System.out.println(JWTUtil.generateJWT4User(user));
    }

    @Test
    void testInsertUser() {
        User user = new User();
        user.setUid("U103");
        user.setPasswd("123456");
        user.setName("Ya lou");
        user.setEmail("103@mail.com");
        user.setPhone("12345678903");

        userMapper.insertUser(user);
    }

    @Test
    void testStringMethod() {
        System.out.println("qingchenjia".contains("gc"));
    }

    @Test
    void testCipherUtil() throws Exception {
        String encrypt = CipherUtil.encrypt("123456");
        System.out.println(encrypt);
    }

    @Test
    void testDateMethod() {
        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 加上 30 天
        LocalDateTime futureDateTime = currentDateTime.plusDays(30);

        // 将 LocalDateTime 转换为 java.sql.Date
        Date sqlDate = Date.valueOf(futureDateTime.toLocalDate());

        // 格式化为 "yyyy-MM-dd HH:mm:ss" 的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = futureDateTime.format(formatter);

        // 输出
        System.out.println("30 天后的日期 (年月日 时分秒): " + formattedDateTime);
        System.out.println("30 天后的 java.sql.Date: " + sqlDate);
    }

    @Test
    void timeStampMethod() {
        // 获取当前时间的 Timestamp
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // 使用 Calendar 来加上 30 天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTimestamp);
        calendar.add(Calendar.DAY_OF_MONTH, 30);  // 加 30 天

        // 获取加上 30 天后的 Timestamp
        Timestamp futureTimestamp = new Timestamp(calendar.getTimeInMillis());

        // 输出当前时间和 30 天后的时间
        System.out.println("当前时间: " + currentTimestamp);
        System.out.println("30 天后的时间: " + futureTimestamp);

        System.out.println(currentTimestamp.getSeconds());
    }

    @Test
    void testBorrowQuery() {
        List<Borrow> borrows = borrowMapper.selectAll();
        borrows.forEach(System.out::println);
    }

    @Test
    void datetimeAfter30days() {
        List<Borrow> borrows = borrowMapper.selectAll();
        for (Borrow borrow : borrows) {
            Timestamp currentTimestamp = borrow.getBorrowDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentTimestamp);
            calendar.add(Calendar.DAY_OF_MONTH, 30);  // 加 30 天

            Timestamp futureTimestamp = new Timestamp(calendar.getTimeInMillis());

            System.out.println("当前时间: " + currentTimestamp);
            System.out.println("30 天后的时间: " + futureTimestamp);
        }
    }

    @Test
    void addNewBorrow() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTimestamp);
        calendar.add(Calendar.DAY_OF_MONTH, 30);  // 加 30 天

        Timestamp futureTimestamp = new Timestamp(calendar.getTimeInMillis());

        borrowMapper.insertBorrowExceptReturnDate("25",
                "U102",
                currentTimestamp,
                futureTimestamp);
    }

    @Test
    void num2Timestamp() {
        Timestamp timestamp = new Timestamp(1726034613000L);
        System.out.println(timestamp);
    }

    @Test
    void testBorrowHistorySort() {
        List<BorrowHistory> borrowHistories = borrowService.queryAllBorrowHistory("U101");
        borrowHistories.forEach(System.out::println);
    }

    @Test
    void testBorrowInfoSort() {
        List<BorrowInfo> borrowInfos = borrowService.queryAllBorrowInfo("U103");
        borrowInfos.forEach(System.out::println);
    }

    @Test
    void testDeleteBookException() {
        bookInfoService.deleteBook("1");
    }

    @Test
    void testBookSearchSort() {
        List<BookSearch> bookSearches = bookInfoService.queryAllBookSearch("user");
        bookSearches.forEach(System.out::println);
    }

    @Test
    void testBookOverviewSort() {
        List<BookOverview> bookOverviews = bookInfoService.queryAllBookOverview();
        bookOverviews.forEach(System.out::println);
    }
}
