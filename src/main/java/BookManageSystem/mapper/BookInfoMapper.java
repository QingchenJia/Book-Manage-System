package BookManageSystem.mapper;

import BookManageSystem.pojo.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("SELECT * FROM book_info")
    @ResultMap("BookInfo")
    List<BookInfo> selectAll();

    @Select("SELECT * FROM book_info WHERE book_name=#{bookName}")
    @ResultMap("BookInfo")
    List<BookInfo> selectByBookName(String bookName);

    @Select("SELECT * FROM book_info WHERE author=#{author}")
    @ResultMap("BookInfo")
    List<BookInfo> selectByAuthor(String author);

    @Select("SELECT * FROM book_info WHERE tid=(SELECT tid FROM book_type WHERE type_name=#{typeName})")
    @ResultMap("BookInfo")
    List<BookInfo> selectByTypeName(String typeName);

    @Select("SELECT * FROM book_info WHERE bid=#{bid}")
    @ResultMap("BookInfo")
    BookInfo selectByBid(String bid);

    @Insert("INSERT INTO book_info VALUES (#{bid},#{bookName},#{author},#{num},#{press},#{tid})")
    void insertBookInfo(BookInfo bookInfo);

    @Delete("DELETE FROM book_info WHERE bid=#{bid}")
    void deleteByBid(String bid);
}
