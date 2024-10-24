package BookManageSystem.service.impl;

import BookManageSystem.exception.BeyondBorrowLimitException;
import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.entity.BookInfo;
import BookManageSystem.pojo.entity.Borrow;
import BookManageSystem.pojo.vo.BorrowHistory;
import BookManageSystem.pojo.vo.BorrowInfo;
import BookManageSystem.pojo.vo.BorrowOverview;
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
    public void borrowBook(String bid, String uid, Timestamp borrowDate) {
        int borrowedNum = borrowMapper.selectBorrowNumByUid(uid);
        int maxBorrowNum = userMapper.selectBorrowNumByUid(uid);

        if (borrowedNum >= maxBorrowNum) {
            throw new BeyondBorrowLimitException("借阅超过上限");
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

    @Override
    public List<BorrowOverview> queryAllBorrowOverview() {
        List<Borrow> borrows = borrowMapper.selectAll();
        return borrows2borrowOverviews(borrows);
    }

    @Override
    public List<BorrowOverview> queryBorrowOverviewByBookName(String bookName) {
        List<Borrow> borrows = borrowMapper.selectByBookName(bookName);
        return borrows2borrowOverviews(borrows);
    }

    @Override
    public List<BorrowOverview> queryBorrowOverviewByBid(String bid) {
        List<Borrow> borrows = borrowMapper.selectByBid(bid);
        return borrows2borrowOverviews(borrows);
    }

    @Override
    public List<BorrowOverview> queryBorrowOverviewByUserName(String userName) {
        List<Borrow> borrows = borrowMapper.selectByUserName(userName);
        return borrows2borrowOverviews(borrows);
    }

    @Override
    public List<BorrowOverview> queryBorrowOverviewByUid(String uid) {
        List<Borrow> borrows = borrowMapper.selectByUid(uid);
        return borrows2borrowOverviews(borrows);
    }

    private List<BorrowInfo> borrows2borrowInfos(List<Borrow> borrows) {
        List<BorrowInfo> borrowInfos = new ArrayList<>();

        for (Borrow borrow : borrows) {
            BookInfo bookInfo = bookInfoMapper.selectByBid(borrow.getBid());

            borrowInfos.add(BorrowInfo.builder()
                    .bookName(bookInfo.getBookName())
                    .bid(borrow.getBid())
                    .borrowDate(borrow.getBorrowDate())
                    .dueDate(borrow.getDueDate())
                    .build()
            );
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

            borrowHistories.add(BorrowHistory.builder()
                    .bookName(bookInfo.getBookName())
                    .bid(borrow.getBid())
                    .borrowDate(borrow.getBorrowDate())
                    .returnDate(borrow.getReturnDate())
                    .build()
            );
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

    private List<BorrowOverview> borrows2borrowOverviews(List<Borrow> borrows) {
        List<BorrowOverview> borrowOverviews = new ArrayList<>();

        for (Borrow borrow : borrows) {
            String bookName = bookInfoMapper.selectByBid(borrow.getBid()).getBookName();
            String userName = userMapper.selectByUid(borrow.getUid()).getName();

            String status = borrow.getIsReturn() == 1 ? "已归还" : "借阅中";

            borrowOverviews.add(BorrowOverview.builder()
                    .bookName(bookName)
                    .bid(borrow.getBid())
                    .uid(borrow.getUid())
                    .userName(userName)
                    .borrowDate(borrow.getBorrowDate())
                    .dueDate(borrow.getDueDate())
                    .status(status)
                    .build());
        }

        borrowOverviews.sort((o1, o2) -> {
            long l = o1.getBorrowDate().getTime() - o2.getBorrowDate().getTime();

            int i = l > 0 ? 1 : -1;
            return -i;
        });

        return borrowOverviews;
    }
}
