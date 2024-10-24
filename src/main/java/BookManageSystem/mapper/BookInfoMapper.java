package BookManageSystem.mapper;

import BookManageSystem.pojo.entity.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("SELECT * FROM book_info WHERE is_delete=0")
    @ResultMap("BookInfo")
    List<BookInfo> selectAll();

    @Select("SELECT * FROM book_info WHERE book_name=#{bookName} AND is_delete=0")
    @ResultMap("BookInfo")
    List<BookInfo> selectByBookName(String bookName);

    @Select("SELECT * FROM book_info WHERE author=#{author} AND is_delete=0")
    @ResultMap("BookInfo")
    List<BookInfo> selectByAuthor(String author);

    @Select("SELECT * FROM book_info WHERE tid=(SELECT tid FROM book_type WHERE type_name=#{typeName}) AND is_delete=0")
    @ResultMap("BookInfo")
    List<BookInfo> selectByTypeName(String typeName);

    @Select("SELECT * FROM book_info WHERE bid=#{bid} AND is_delete=0")
    @ResultMap("BookInfo")
    BookInfo selectByBid(String bid);

    @Insert("INSERT INTO book_info VALUES (#{bid},#{bookName},#{author},#{num},#{press},#{tid},0)")
    void insertBookInfo(BookInfo bookInfo);

    @Update("UPDATE book_info SET is_delete=1 WHERE bid=#{bid}")
    void deleteByBid(String bid);   // 逻辑删除
}
