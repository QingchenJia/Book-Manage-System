package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    public BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> queryAllBook() {
        return bookInfoMapper.selectAll();
    }

    @Override
    public List<BookInfo> queryBookByBookName(String bookName) {
        return bookInfoMapper.selectByBookName(bookName);
    }

    @Override
    public List<BookInfo> queryBookByAuthor(String author) {
        return bookInfoMapper.selectByAuthor(author);
    }

    @Override
    public List<BookInfo> queryBookByTypeName(String typeName) {
        return bookInfoMapper.selectByTypeName(typeName);
    }

    @Override
    public BookInfo queryBookByBid(String bid) {
        return bookInfoMapper.selectByBid(bid);
    }
}
