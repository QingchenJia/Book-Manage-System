package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.data.BookSearch;
import BookManageSystem.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    public BookInfoMapper bookInfoMapper;
    @Autowired
    public BookTypeMapper bookTypeMapper;
    @Autowired
    public BorrowMapper borrowMapper;

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
    public List<BookInfo> queryBookByBid(String bid) {
        return bookInfoMapper.selectByBid(bid);
    }

    @Override
    public List<BookSearch> queryAllBookSearch(String uid) {
        List<BookInfo> bookInfos = bookInfoMapper.selectAll();
        return bookInfos2bookSearches(uid, bookInfos);
    }

    @Override
    public List<BookSearch> queryBookSearchByBookName(String uid, String bookName) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByBookName(bookName);
        return bookInfos2bookSearches(uid, bookInfos);
    }

    @Override
    public List<BookSearch> queryBookSearchByAuthor(String uid, String author) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByAuthor(author);
        return bookInfos2bookSearches(uid, bookInfos);
    }

    @Override
    public List<BookSearch> queryBookSearchByTypeName(String uid, String typeName) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByTypeName(typeName);
        return bookInfos2bookSearches(uid, bookInfos);
    }

    @Override
    public List<BookSearch> queryBookSearchByBid(String uid, String bid) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByBid(bid);
        return bookInfos2bookSearches(uid, bookInfos);
    }

    private List<BookSearch> bookInfos2bookSearches(String uid, List<BookInfo> bookInfos) {
        List<BookSearch> bookSearches = new ArrayList<>();

        for (BookInfo bookInfo : bookInfos) {
            BookType bookType = bookTypeMapper.selectByTid(bookInfo.getTid());
            int borrowNum = borrowMapper.selectBorrowNumByBid(bookInfo.getBid());
            Borrow borrow = borrowMapper.selectByBidAndUid(bookInfo.getBid(), uid);

            bookSearches.add(new BookSearch(
                    bookInfo.getBookName(),
                    bookInfo.getBid(),
                    bookInfo.getAuthor(),
                    bookInfo.getNum() - borrowNum,
                    bookInfo.getPress(),
                    bookType.getTypeName(),
                    borrow != null && borrow.getIsReturn() == 0 ? "借阅中" : "注意余量"
            ));
        }

        return bookSearches;
    }
}
