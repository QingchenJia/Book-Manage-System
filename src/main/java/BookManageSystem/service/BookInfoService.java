package BookManageSystem.service;

import BookManageSystem.pojo.BookInfo;
import BookManageSystem.pojo.resp.data.BookSearch;

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
}
