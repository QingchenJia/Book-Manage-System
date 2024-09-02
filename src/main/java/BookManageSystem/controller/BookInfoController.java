package BookManageSystem.controller;

import BookManageSystem.pojo.tool.Result;
import BookManageSystem.service.BookInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BookInfo")
public class BookInfoController {
    public final BookInfoService bookInfoService;

    public BookInfoController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @GetMapping("/selectAll")
    public Result selectAll() {
        List<String> data = bookInfoService.selectAll();
        return Result.success("查询成功!", data);
    }
}
