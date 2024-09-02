package BookManageSystem;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.pojo.Admin;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.BookType;
import BookManageSystem.service.BookInfoService;
import BookManageSystem.utils.JSONUtil;
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
        System.out.println(bookInfoService.selectAll());
    }
}
