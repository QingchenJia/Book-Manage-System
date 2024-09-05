package BookManageSystem.mapper;

import BookManageSystem.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("SELECT * FROM borrow")
    @ResultMap("Borrow")
    List<Borrow> selectAll();

    @Select("SELECT * FROM borrow WHERE bid IN (SELECT bid FROM book_info WHERE book_name=#{bookName})")
    @ResultMap("Borrow")
    List<Borrow> selectByBookName(String bookName);

    @Select("SELECT * FROM borrow WHERE uid=#{uid}")
    @ResultMap("Borrow")
    List<Borrow> selectByUid(String uid);

    @Select("SELECT * FROM borrow WHERE uid IN (SELECT uid FROM user WHERE name=#{userName})")
    @ResultMap("Borrow")
    List<Borrow> selectByUserName(String userName);

    @Select("SELECT * FROM borrow WHERE bid=#{bid}")
    @ResultMap("Borrow")
    List<Borrow> selectByBid(String bid);

    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=0")
    @ResultMap("Borrow")
    List<Borrow> selectByUidAndIsNotReturn(String uid);


    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=0 AND bid IN (SELECT bid FROM book_info WHERE book_name=#{bookName})")
    @ResultMap("Borrow")
    List<Borrow> selectByUidAndIsNotReturnAndBookName(String uid, String bookName);

    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=0 AND bid=#{bid}")
    @ResultMap("Borrow")
    Borrow selectByUidAndIsNotReturnAndBid(String uid, String bid);
}
