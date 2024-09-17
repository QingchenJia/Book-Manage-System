package BookManageSystem.controller;

import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        List<BookType> bookType = bookTypeService.queryTypeByTypeName(typeName);
        return Result.success(bookType);
    }

    @GetMapping("/queryByTid")
    public Result queryByTid(String tid) {
        List<BookType> bookType = bookTypeService.queryTypeByTid(tid);
        return Result.success(bookType);
    }

    @PostMapping("/addNewType")
    public Result addNewType(@RequestBody BookType bookType) {
        bookTypeService.addNewType(bookType);
        return Result.success("添加成功");
    }

    @PostMapping("/deleteType")
    public Result deleteType(@RequestBody Map<String, Object> params) {
        String tid = (String) params.get("tid");
        bookTypeService.deleteTypeByTid(tid);

        return Result.success("删除成功");
    }
}
