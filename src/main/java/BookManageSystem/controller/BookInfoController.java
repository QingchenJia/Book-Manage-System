package BookManageSystem.controller;

import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.tool.Result;
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
        BookInfo bookInfo = bookInfoService.queryBookByBid(bid);
        return Result.success(bookInfo);
    }
}
