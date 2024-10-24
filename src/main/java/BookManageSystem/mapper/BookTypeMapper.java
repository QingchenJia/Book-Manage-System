package BookManageSystem.mapper;

import BookManageSystem.pojo.entity.BookType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    @Select("SELECT * FROM book_type WHERE is_delete=0")
    @ResultMap("BookType")
    List<BookType> selectAll();

    @Select("SELECT * FROM book_type WHERE tid=#{tid} AND is_delete=0")
    @ResultMap("BookType")
    BookType selectByTid(String tid);

    @Select("SELECT * FROM book_type WHERE type_name=#{typeName} AND is_delete=0")
    @ResultMap("BookType")
    BookType selectByTypeName(String typeName);

    @Insert("INSERT INTO book_type VALUES (#{tid},#{typeName},0)")
    @ResultMap("BookType")
    void insertBookType(BookType bookType);

    @Update("UPDATE book_type SET is_delete=1 WHERE tid=#{tid}")
    void deleteByTid(String tid);

    @Select("SELECT COUNT(*) FROM book_info WHERE tid=#{tid}")
    int selectBookNumByTid(String Tid);
}
