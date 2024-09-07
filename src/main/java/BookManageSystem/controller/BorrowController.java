package BookManageSystem.controller;

import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.pojo.resp.data.BorrowInfo;
import BookManageSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Borrow")
public class BorrowController {
    @Autowired
    public BorrowService borrowService;

    @GetMapping("/queryAll")
    public Result queryAll() {
        List<Borrow> borrows = borrowService.queryAllBorrow();
        return Result.success(borrows);
    }

    @GetMapping("/queryByBookName")
    public Result queryByBookName(String bookName) {
        List<Borrow> borrows = borrowService.queryBorrowByBookName(bookName);
        return Result.success(borrows);
    }

    @GetMapping("/queryByUid")
    public Result queryByUid(String uid) {
        List<Borrow> borrows = borrowService.queryBorrowByUid(uid);
        return Result.success(borrows);
    }

    @GetMapping("/queryByUserName")
    public Result queryByUserName(String userName) {
        List<Borrow> borrows = borrowService.queryBorrowByUserName(userName);
        return Result.success(borrows);
    }

    @GetMapping("/queryByBid")
    public Result queryByBid(String bid) {
        List<Borrow> borrows = borrowService.queryBorrowByBid(bid);
        return Result.success(borrows);
    }

    @GetMapping("/queryAllBorrowInfo")
    public Result queryAllBorrowInfo(String uid) {
        List<BorrowInfo> borrowInfos = borrowService.queryAllBorrowInfo(uid);
        return Result.success(borrowInfos);
    }

    @GetMapping("/queryBorrowInfoByBookName")
    public Result queryBorrowInfoByBookName(String uid, String bookName) {
        List<BorrowInfo> borrowInfos = borrowService.queryBorrowInfoByBookName(uid, bookName);
        return Result.success(borrowInfos);
    }

    @GetMapping("/queryBorrowInfoByBid")
    public Result queryBorrowInfoByBid(String uid, String bid) {
        List<BorrowInfo> borrowInfos = borrowService.queryBorrowInfoByBid(uid, bid);
        return Result.success(borrowInfos);
    }
}
