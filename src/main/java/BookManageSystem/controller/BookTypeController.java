package BookManageSystem.controller;

import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.tool.Result;
import BookManageSystem.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BookType")
public class BookTypeController {
    @Autowired
    public BookTypeService bookTypeService;

    @GetMapping("/queryAll")
    public Result queryAll() {
        List<BookType> bookTypes = bookTypeService.queryAllType();
        return Result.success(bookTypes);
    }

    @GetMapping("/queryByTypeName")
    public Result queryByTypeName(String typeName) {
        BookType bookType = bookTypeService.queryTypeByTypeName(typeName);
        return Result.success(bookType);
    }

    @PostMapping("/addNewType")
    public Result addNewType(BookType bookType) {
        bookTypeService.addNewType(bookType);
        return Result.success();
    }

    @DeleteMapping("/deleteType")
    public Result deleteType(String tid) {
        bookTypeService.deleteTypeByTid(tid);
        return Result.success();
    }
}
