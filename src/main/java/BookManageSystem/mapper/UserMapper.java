package BookManageSystem.mapper;

import BookManageSystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE uid=#{uid} AND passwd=#{passwd}")
    @ResultMap("User")
    User selectByUidAndPasswd(User user);
}
