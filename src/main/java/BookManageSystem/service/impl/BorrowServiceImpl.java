package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.data.BorrowHistory;
import BookManageSystem.pojo.resp.data.BorrowInfo;
import BookManageSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    public BorrowMapper borrowMapper;
    @Autowired
    public BookInfoMapper bookInfoMapper;
    @Autowired
    public UserMapper userMapper;

    @Override
    public List<Borrow> queryAllBorrow() {
        return borrowMapper.selectAll();
    }

    @Override
    public List<Borrow> queryBorrowByBookName(String bookName) {
        return borrowMapper.selectByBookName(bookName);
    }

    @Override
    public List<Borrow> queryBorrowByUid(String uid) {
        return borrowMapper.selectByUid(uid);
    }

    @Override
    public List<Borrow> queryBorrowByUserName(String userName) {
        return borrowMapper.selectByUserName(userName);
    }

    @Override
    public List<Borrow> queryBorrowByBid(String bid) {
        return borrowMapper.selectByBid(bid);
    }

    @Override
    public List<BorrowInfo> queryAllBorrowInfo(String uid) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsNotReturn(uid);
        return borrows2borrowInfos(borrows);
    }

    @Override
    public List<BorrowInfo> queryBorrowInfoByBookName(String uid, String bookName) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsNotReturnAndBookName(uid, bookName);
        return borrows2borrowInfos(borrows);
    }

    @Override
    public List<BorrowInfo> queryBorrowInfoByBid(String uid, String bid) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsNotReturnAndBid(uid, bid);
        return borrows2borrowInfos(borrows);
    }

    @Override
    public List<BorrowHistory> queryAllBorrowHistory(String uid) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsReturn(uid);
        return borrows2borrowHistories(borrows);
    }

    @Override
    public List<BorrowHistory> queryBorrowHistoryByBookName(String uid, String bookName) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsReturnAndBookName(uid, bookName);
        return borrows2borrowHistories(borrows);
    }

    @Override
    public List<BorrowHistory> queryBorrowHistoryByBid(String uid, String bid) {
        List<Borrow> borrows = borrowMapper.selectByUidAndIsReturnAndBid(uid, bid);
        return borrows2borrowHistories(borrows);
    }

    @Override
    public void borrowBook(String bid, String uid, Timestamp borrowDate) throws Exception {
        int borrowedNum = borrowMapper.selectBorrowNumByUid(uid);
        int maxBorrowNum = userMapper.selectBorrowNumByUid(uid);

        if (borrowedNum == maxBorrowNum) {
            throw new Exception("借阅数量已达上限");
        }

        int borrowDays = userMapper.selectBorrowDaysByUid(uid);
        Timestamp dueDate = getTimestampAfterDays(borrowDate, borrowDays);

        borrowMapper.insertBorrowExceptReturnDate(bid, uid, borrowDate, dueDate);
    }

    @Override
    public void returnBook(String bid, String uid, Timestamp borrowDate, Timestamp returnDate) {
        borrowMapper.updateReturnDateAndIsReturn(bid, uid, borrowDate, returnDate);
    }

    @Override
    public void returnBook(String bid, String uid, Timestamp returnDate) {
        Borrow borrow = borrowMapper.selectByBidAndUidAndIsNotReturn(bid, uid);
        Timestamp borrowDate = borrow.getBorrowDate();

        borrowMapper.updateReturnDateAndIsReturn(bid, uid, borrowDate, returnDate);
    }

    private List<BorrowInfo> borrows2borrowInfos(List<Borrow> borrows) {
        List<BorrowInfo> borrowInfos = new ArrayList<>();

        for (Borrow borrow : borrows) {
            BookInfo bookInfo = bookInfoMapper.selectByBid(borrow.getBid());

            borrowInfos.add(new BorrowInfo(
                    bookInfo.getBookName(),
                    borrow.getBid(),
                    borrow.getBorrowDate(),
                    borrow.getDueDate()
            ));
        }

        borrowInfos.sort((o1, o2) -> {
            long l = o1.getBorrowDate().getTime() - o2.getBorrowDate().getTime();

            int i = l > 0 ? 1 : -1;
            return -i;
        });

        return borrowInfos;
    }

    private List<BorrowHistory> borrows2borrowHistories(List<Borrow> borrows) {
        List<BorrowHistory> borrowHistories = new ArrayList<>();

        for (Borrow borrow : borrows) {
            BookInfo bookInfo = bookInfoMapper.selectByBid(borrow.getBid());

            borrowHistories.add(new BorrowHistory(
                    bookInfo.getBookName(),
                    borrow.getBid(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            ));
        }

        borrowHistories.sort((o1, o2) -> {
            // 进行排序 借阅时间归还时间靠前 排序靠后
            long l = o1.getBorrowDate().getTime() - o2.getBorrowDate().getTime();
            l = l == 0 ? o1.getReturnDate().getTime() - o2.getReturnDate().getTime() : l;

            int i = l > 0 ? 1 : -1;
            return -i;
        });

        return borrowHistories;
    }

    private Timestamp getTimestampAfterDays(Timestamp timestamp, int days) {
        // 获取指定日期时间后多少天的日期时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return new Timestamp(calendar.getTimeInMillis());
    }
}
