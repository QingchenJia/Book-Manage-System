package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.pojo.BookType;
import BookManageSystem.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    public BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> queryAllType() {
        return bookTypeMapper.selectAll();
    }

    @Override
    public List<BookType> queryTypeByTypeName(String typeName) {
        BookType bookType = bookTypeMapper.selectByTypeName(typeName);
        List<BookType> bookTypes = new ArrayList<>();
        bookTypes.add(bookType);

        return bookTypes;
    }

    @Override
    public List<BookType> queryTypeByTid(String tid) {
        BookType bookType = bookTypeMapper.selectByTid(tid);
        List<BookType> bookTypes = new ArrayList<>();
        bookTypes.add(bookType);

        return bookTypes;
    }

    @Override
    public void addNewType(BookType bookType) {
        bookTypeMapper.insertBookType(bookType);
    }

    @Override
    public void deleteTypeByTid(String tid) {
        bookTypeMapper.deleteByTid(tid);
    }
}
