package BookManageSystem;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.Admin;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.User;
import BookManageSystem.service.BookInfoService;
import BookManageSystem.utils.CipherUtil;
import BookManageSystem.utils.JSONUtil;
import BookManageSystem.utils.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void testParseToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiJVMTAxIiwicGFzc3dkIjoiMTIzNDU2IiwiZXhwIjoxNzI1MjgzMDIwfQ.KLNbvbzjjKJ8e6ncO0vsotuMQ8G30uy_xSdWHjXXl94";
        User user = null;
        try {
            user = JWTUtil.verifyJWT4User(token);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("令牌失效");
        }
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
}
