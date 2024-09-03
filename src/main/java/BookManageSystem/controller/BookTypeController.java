package BookManageSystem.controller;

import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.tool.Result;
import BookManageSystem.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BookType")
public class BookTypeController {
    @Autowired
    public BookTypeService bookTypeService;

    @GetMapping("/selectAll")
    public Result selectAll() {
        List<BookType> bookTypes = bookTypeService.queryAllType();
        return Result.success("查询成功", bookTypes);
    }
}
