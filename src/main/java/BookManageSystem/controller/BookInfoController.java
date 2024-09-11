package BookManageSystem.controller;

import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.pojo.resp.data.BookSearch;
import BookManageSystem.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BookInfo")
public class BookInfoController {
    @Autowired
    public BookInfoService bookInfoService;

    @GetMapping("/queryAll")
    public Result queryAll() {
        List<BookInfo> data = bookInfoService.queryAllBook();
        return Result.success(data);
    }

    @GetMapping("/queryByBookName")
    public Result queryByBookName(String bookName) {
        List<BookInfo> bookInfos = bookInfoService.queryBookByBookName(bookName);
        return Result.success(bookInfos);
    }

    @GetMapping("/queryByAuthor")
    public Result queryByAuthor(String author) {
        List<BookInfo> bookInfos = bookInfoService.queryBookByAuthor(author);
        return Result.success(bookInfos);
    }

    @GetMapping("/queryByTypeName")
    public Result queryByTypeName(String typeName) {
        List<BookInfo> bookInfos = bookInfoService.queryBookByTypeName(typeName);
        return Result.success(bookInfos);
    }

    @GetMapping("/queryByBid")
    public Result queryByBid(String bid) {
        List<BookInfo> bookInfos = bookInfoService.queryBookByBid(bid);
        return Result.success(bookInfos);
    }

    @GetMapping("/queryAllBookSearch")
    public Result queryAllBookSearch(String uid) {
        List<BookSearch> bookSearches = bookInfoService.queryAllBookSearch(uid);
        return Result.success(bookSearches);
    }

    @GetMapping("/queryBookSearchByBookName")
    public Result queryBookSearchByBookName(String uid, String bookName) {
        List<BookSearch> bookSearches = bookInfoService.queryBookSearchByBookName(uid, bookName);
        return Result.success(bookSearches);
    }

    @GetMapping("/queryBookSearchByAuthor")
    public Result queryBookSearchByAuthor(String uid, String author) {
        List<BookSearch> bookSearches = bookInfoService.queryBookSearchByAuthor(uid, author);
        return Result.success(bookSearches);
    }

    @GetMapping("/queryBookSearchByTypeName")
    public Result queryBookSearchByTypeName(String uid, String typeName) {
        List<BookSearch> bookSearches = bookInfoService.queryBookSearchByTypeName(uid, typeName);
        return Result.success(bookSearches);
    }

    @GetMapping("/queryBookSearchByBid")
    public Result queryBookSearchByBid(String uid, String bid) {
        List<BookSearch> bookSearches = bookInfoService.queryBookSearchByBid(uid, bid);
        return Result.success(bookSearches);
    }
}
