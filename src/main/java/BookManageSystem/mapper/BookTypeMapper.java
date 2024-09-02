package BookManageSystem.mapper;

import BookManageSystem.pojo.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    @Select("SELECT * FROM book_type")
    @ResultMap("BookType")
    List<BookType> selectAll();
}
