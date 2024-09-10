package BookManageSystem.mapper;

import BookManageSystem.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE uid=#{uid} AND passwd=#{passwd}")
    @ResultMap("User")
    User selectByUidAndPasswd(User user);

    @Insert("INSERT INTO user VALUES (#{uid},#{passwd},#{name},#{email},#{phone},5,30)")
    @ResultMap("User")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE uid=#{uid}")
    @ResultMap("User")
    User selectByUid(String uid);

    @Select("SELECT * FROM user WHERE name=#{name}")
    @ResultMap("User")
    List<User> selectByName(String name);

    void updateUser(User user);

    @Select("SELECT borrow_days FROM user WHERE uid=#{uid}")
    int selectBorrowDaysByUid(String uid);

    @Select("SELECT borrow_num FROM user WHERE uid=#{uid}")
    int selectBorrowNumByUid(String uid);
}
