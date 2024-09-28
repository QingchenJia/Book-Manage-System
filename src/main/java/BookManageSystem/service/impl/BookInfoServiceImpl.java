package BookManageSystem.service.impl;

import BookManageSystem.mapper.BookInfoMapper;
import BookManageSystem.mapper.BookTypeMapper;
import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.BookType;
import BookManageSystem.pojo.Borrow;
import BookManageSystem.pojo.resp.vo.BookOverview;
import BookManageSystem.pojo.resp.vo.BookSearch;
import BookManageSystem.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
        BookInfo bookInfo = bookInfoMapper.selectByBid(bid);
        List<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(bookInfo);

        return bookInfos;
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
        BookInfo bookInfo = bookInfoMapper.selectByBid(bid);
        List<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(bookInfo);

        return bookInfos2bookSearches(uid, bookInfos);
    }

    @Override
    public List<BookOverview> queryAllBookOverview() {
        List<BookInfo> bookInfos = bookInfoMapper.selectAll();
        return bookInfos2bookOverviews(bookInfos);
    }

    @Override
    public List<BookOverview> queryBookOverviewByBookName(String bookName) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByBookName(bookName);
        return bookInfos2bookOverviews(bookInfos);
    }

    @Override
    public List<BookOverview> queryBookOverviewByBid(String bid) {
        BookInfo bookInfo = bookInfoMapper.selectByBid(bid);
        List<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(bookInfo);

        return bookInfos2bookOverviews(bookInfos);
    }

    @Override
    public List<BookOverview> queryBookOverviewByAuthor(String author) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByAuthor(author);
        return bookInfos2bookOverviews(bookInfos);
    }

    @Override
    public List<BookOverview> queryBookOverviewByTypeName(String typeName) {
        List<BookInfo> bookInfos = bookInfoMapper.selectByTypeName(typeName);
        return bookInfos2bookOverviews(bookInfos);
    }

    @Override
    public void addNewBook(BookOverview bookOverview) {
        String tid = bookTypeMapper.selectByTypeName(bookOverview.getTypeName()).getTid();

        BookInfo bookInfo = new BookInfo(
                bookOverview.getBid(),
                bookOverview.getBookName(),
                bookOverview.getAuthor(),
                bookOverview.getNum(),
                bookOverview.getPress(),
                tid,
                0
        );

        bookInfoMapper.insertBookInfo(bookInfo);
    }

    @Override
    public void deleteBook(String bid) {
        bookInfoMapper.deleteByBid(bid);
    }

    private List<BookSearch> bookInfos2bookSearches(String uid, List<BookInfo> bookInfos) {
        List<BookSearch> bookSearches = new ArrayList<>();

        for (BookInfo bookInfo : bookInfos) {
            BookType bookType = bookTypeMapper.selectByTid(bookInfo.getTid());
            int borrowNum = borrowMapper.selectBorrowNumByBid(bookInfo.getBid());
            Borrow borrow = borrowMapper.selectByBidAndUidAndIsNotReturn(bookInfo.getBid(), uid);   // 同一个人借阅同一本书可能多次 仅查询最新一次 即尚未归还

            bookSearches.add(new BookSearch(
                    bookInfo.getBookName(),
                    bookInfo.getBid(),
                    bookInfo.getAuthor(),
                    bookInfo.getNum() - borrowNum,  // 书籍存量减去借出数量得到余量
                    bookInfo.getPress(),
                    bookType.getTypeName(),
                    borrow != null && borrow.getIsReturn() == 0 ? "借阅中" : "注意余量"
            ));
        }

        bookSearches.sort(Comparator.comparing(BookSearch::getBid));    // 根据ID字符串排序

        return bookSearches;
    }


    private List<BookOverview> bookInfos2bookOverviews(List<BookInfo> bookInfos) {
        List<BookOverview> bookOverviews = new ArrayList<>();

        for (BookInfo bookInfo : bookInfos) {
            int borrowedNum = borrowMapper.selectBorrowNumByBid(bookInfo.getBid()); // 借出数量
            int leftNum = bookInfo.getNum() - borrowedNum;  // 库存余量

            String typeName = bookTypeMapper.selectByTid(bookInfo.getTid()).getTypeName();

            bookOverviews.add(new BookOverview(
                    bookInfo.getBookName(),
                    bookInfo.getBid(),
                    bookInfo.getAuthor(),
                    leftNum,
                    bookInfo.getPress(),
                    typeName
            ));
        }

        bookOverviews.sort(Comparator.comparing(BookOverview::getBid));

        return bookOverviews;
    }
}
