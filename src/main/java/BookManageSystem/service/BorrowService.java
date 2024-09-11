package BookManageSystem.service;

import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.data.BorrowHistory;
import BookManageSystem.pojo.resp.data.BorrowInfo;

import java.sql.Timestamp;
import java.util.List;

public interface BorrowService {
    List<Borrow> queryAllBorrow();

    List<Borrow> queryBorrowByBookName(String bookName);

    List<Borrow> queryBorrowByUid(String uid);

    List<Borrow> queryBorrowByUserName(String userName);

    List<Borrow> queryBorrowByBid(String bid);

    List<BorrowInfo> queryAllBorrowInfo(String uid);

    List<BorrowInfo> queryBorrowInfoByBookName(String uid, String bookName);

    List<BorrowInfo> queryBorrowInfoByBid(String uid, String bid);

    List<BorrowHistory> queryAllBorrowHistory(String uid);

    List<BorrowHistory> queryBorrowHistoryByBookName(String uid, String bookName);

    List<BorrowHistory> queryBorrowHistoryByBid(String uid, String bid);

    void borrowBook(String bid, String uid, Timestamp borrowDate) throws Exception;

    void returnBook(String bid, String uid, Timestamp borrowDate, Timestamp returnDate);

    void returnBook(String bid, String uid, Timestamp returnDate);
}
