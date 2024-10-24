package BookManageSystem.controller;

import BookManageSystem.pojo.entity.BookInfo;
import BookManageSystem.common.Result;
import BookManageSystem.pojo.vo.BookOverview;
import BookManageSystem.pojo.vo.BookSearch;
import BookManageSystem.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/BookInfo")
public class BookInfoController {
    @Autowired
    public BookInfoService bookInfoService;

    @GetMapping("/queryAll")
    public Result queryAll() {
        List<BookInfo> bookInfos = bookInfoService.queryAllBook();
        return Result.success(bookInfos);
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

    @GetMapping("/queryAllBookOverview")
    public Result queryAllBookOverview() {
        List<BookOverview> bookOverviews = bookInfoService.queryAllBookOverview();
        return Result.success(bookOverviews);
    }

    @GetMapping("/queryBookOverviewByBookName")
    public Result queryBookOverviewByBookName(String bookName) {
        List<BookOverview> bookOverviews = bookInfoService.queryBookOverviewByBookName(bookName);
        return Result.success(bookOverviews);
    }

    @GetMapping("/queryBookOverviewByBid")
    public Result queryBookOverviewByBid(String bid) {
        List<BookOverview> bookOverviews = bookInfoService.queryBookOverviewByBid(bid);
        return Result.success(bookOverviews);
    }

    @GetMapping("/queryBookOverviewByAuthor")
    public Result queryBookOverviewByAuthor(String author) {
        List<BookOverview> bookOverviews = bookInfoService.queryBookOverviewByAuthor(author);
        return Result.success(bookOverviews);
    }

    @GetMapping("/queryBookOverviewByTypeName")
    public Result queryBookOverviewByTypeName(String typeName) {
        List<BookOverview> bookOverviews = bookInfoService.queryBookOverviewByTypeName(typeName);
        return Result.success(bookOverviews);
    }

    @PostMapping("/addNewBook")
    public Result addNewBook(@RequestBody BookOverview bookOverview) {
        bookInfoService.addNewBook(bookOverview);
        return Result.success("新增成功");
    }

    @PostMapping("/deleteBook")
    public Result deleteBook(@RequestBody Map<String, Object> params) {
        String bid = (String) params.get("bid");
        bookInfoService.deleteBook(bid);

        return Result.success("删除成功");
    }
}
