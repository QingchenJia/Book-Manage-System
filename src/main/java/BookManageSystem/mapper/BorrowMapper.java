package BookManageSystem.mapper;

import BookManageSystem.pojo.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("SELECT * FROM borrow")
    @ResultMap("Borrow")
    List<Borrow> selectAll();

    @Select("SELECT * FROM borrow WHERE bid=#{bid} AND uid=#{uid} AND is_return=0")
    @ResultMap("Borrow")
    Borrow selectByBidAndUidAndIsNotReturn(String bid, String uid);

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
    List<Borrow> selectByUidAndIsNotReturnAndBid(String uid, String bid);

    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=1")
    @ResultMap("Borrow")
    List<Borrow> selectByUidAndIsReturn(String uid);

    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=1 AND bid IN (SELECT bid FROM book_info WHERE book_name=#{bookName})")
    @ResultMap("Borrow")
    List<Borrow> selectByUidAndIsReturnAndBookName(String uid, String bookName);

    @Select("SELECT * FROM borrow WHERE uid=#{uid} AND is_return=1 AND bid=#{bid}")
    @ResultMap("Borrow")
    List<Borrow> selectByUidAndIsReturnAndBid(String uid, String bid);

    @Select("SELECT COUNT(*) FROM borrow WHERE bid=${bid} AND is_return=0")
    int selectBorrowNumByBid(String bid);

    @Select("SELECT COUNT(*) FROM borrow WHERE uid=#{uid} AND is_return=0")
    int selectBorrowNumByUid(String uid);

    @Insert("INSERT INTO borrow (bid, uid, borrow_date, due_date, is_return) VALUES (#{bid},#{uid},#{borrowDate},#{dueDate},0)")
    void insertBorrowExceptReturnDate(String bid, String uid, Timestamp borrowDate, Timestamp dueDate);

    @Update("UPDATE borrow SET return_date=#{returnDate},is_return=1 WHERE bid=#{bid} AND uid=#{uid} AND borrow_date=#{borrowDate}")
    void updateReturnDateAndIsReturn(String bid, String uid, Timestamp borrowDate, Timestamp returnDate);
}
