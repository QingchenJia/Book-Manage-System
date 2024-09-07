package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.data.BorrowHistory;
import BookManageSystem.pojo.resp.data.BorrowInfo;
import BookManageSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    public BorrowMapper borrowMapper;
    @Autowired
    public BookInfoMapper bookInfoMapper;

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

        return borrowHistories;
    }
}
