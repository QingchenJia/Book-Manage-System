package BookManageSystem.mapper;

import BookManageSystem.pojo.BookType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    @Select("SELECT * FROM book_type")
    @ResultMap("BookType")
    List<BookType> selectAll();

    @Select("SELECT * FROM book_type WHERE tid=#{tid}")
    @ResultMap("BookType")
    BookType selectByTid(String tid);

    @Select("SELECT * FROM book_type WHERE type_name=#{typeName}")
    @ResultMap("BookType")
    BookType selectByTypeName(String typeName);

    @Insert("INSERT INTO book_type VALUES (#{tid},#{typeName})")
    @ResultMap("BookType")
    void insertBookType(BookType bookType);

    @Delete("DELETE FROM book_type WHERE tid=#{tid}")
    void deleteByTid(String tid);
}
