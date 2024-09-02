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
}
