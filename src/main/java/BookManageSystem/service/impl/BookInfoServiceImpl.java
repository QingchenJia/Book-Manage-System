package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.service.BookInfoService;
import BookManageSystem.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    public BookInfoMapper bookInfoMapper;

    @Override
    public List<String> queryAllBook() {
        List<BookInfo> bookInfos = bookInfoMapper.selectAll();
        return bookInfos.stream().map(JSONUtil::object2JSON).toList();
    }
}
