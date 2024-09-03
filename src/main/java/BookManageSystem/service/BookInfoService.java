package BookManageSystem.service;

import BookManageSystem.pojo.BookInfo;

import java.util.List;

public interface BookInfoService {
    List<BookInfo> queryAllBook();

    List<BookInfo> queryBookByBookName(String bookName);

    List<BookInfo> queryBookByAuthor(String author);

    List<BookInfo> queryBookByTypeName(String typeName);

    BookInfo queryBookByBid(String bid);
}
