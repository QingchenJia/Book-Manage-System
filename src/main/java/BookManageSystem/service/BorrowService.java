package BookManageSystem.service;

import BookManageSystem.pojo.entity.Borrow;
import BookManageSystem.pojo.vo.BorrowHistory;
import BookManageSystem.pojo.vo.BorrowInfo;
import BookManageSystem.pojo.vo.BorrowOverview;

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

    List<BorrowOverview> queryAllBorrowOverview();

    List<BorrowOverview> queryBorrowOverviewByBookName(String bookName);

    List<BorrowOverview> queryBorrowOverviewByBid(String bid);

    List<BorrowOverview> queryBorrowOverviewByUserName(String userName);

    List<BorrowOverview> queryBorrowOverviewByUid(String uid);
}
