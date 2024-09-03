package BookManageSystem.mapper;

import BookManageSystem.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT bid, book_name, author, num, press, book_info.tid, status FROM book_info,book_type WHERE book_info.tid=book_type.tid AND type_name=#{typeName}")
    @ResultMap("BookInfo")
    List<BookInfo> selectByTypeName(String typeName);

    @Select("SELECT * FROM book_info WHERE bid=#{bid}")
    @ResultMap("BookInfo")
    BookInfo selectByBid(String bid);
}
