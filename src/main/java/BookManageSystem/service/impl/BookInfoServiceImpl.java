package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.service.BookInfoService;
import BookManageSystem.utils.JSONUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    public final BookInfoMapper bookInfoMapper;

    public BookInfoServiceImpl(BookInfoMapper bookInfoMapper) {
        this.bookInfoMapper = bookInfoMapper;
    }

    @Override
    public List<String> selectAll() {
        List<BookInfo> bookInfos = bookInfoMapper.selectAll();
        return bookInfos.stream().map(JSONUtil::object2JSON).toList();
    }
}
