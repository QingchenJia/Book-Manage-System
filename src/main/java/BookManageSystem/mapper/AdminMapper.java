package BookManageSystem.mapper;

import BookManageSystem.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE aid=#{aid} AND passwd=#{passwd}")
    @ResultMap("Admin")
    Admin searchByAidAndPasswd(Admin admin);

    @Update("UPDATE admin SET passwd=#{passwd} WHERE aid=#{aid}")
    @ResultMap("Admin")
    void updatePasswd(Admin admin);
}
