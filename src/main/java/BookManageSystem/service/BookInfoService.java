package BookManageSystem.service;

import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.resp.vo.BookOverview;
import BookManageSystem.pojo.resp.vo.BookSearch;

import java.util.List;

public interface BookInfoService {
    List<BookInfo> queryAllBook();

    List<BookInfo> queryBookByBookName(String bookName);

    List<BookInfo> queryBookByAuthor(String author);

    List<BookInfo> queryBookByTypeName(String typeName);

    List<BookInfo> queryBookByBid(String bid);

    List<BookSearch> queryAllBookSearch(String uid);

    List<BookSearch> queryBookSearchByBookName(String uid, String bookName);

    List<BookSearch> queryBookSearchByAuthor(String uid, String author);

    List<BookSearch> queryBookSearchByTypeName(String uid, String typeName);

    List<BookSearch> queryBookSearchByBid(String uid, String bid);

    List<BookOverview> queryAllBookOverview();

    List<BookOverview> queryBookOverviewByBookName(String bookName);

    List<BookOverview> queryBookOverviewByBid(String bid);

    List<BookOverview> queryBookOverviewByAuthor(String author);

    List<BookOverview> queryBookOverviewByTypeName(String typeName);

    void addNewBook(BookOverview bookOverview);

    void deleteBook(String bid);
}
