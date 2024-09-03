package BookManageSystem.service;

import BookManageSystem.pojo.BookType;

import java.util.List;

public interface BookTypeService {
    List<BookType> queryAllType();

    BookType queryTypeByTypeName(String typeName);

    void addNewType(BookType bookType);

    void deleteTypeByTid(String tid);
}
