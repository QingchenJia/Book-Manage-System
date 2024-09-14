package BookManageSystem.service;

import BookManageSystem.pojo.BookType;

import java.util.List;

public interface BookTypeService {
    List<BookType> queryAllType();

    List<BookType> queryTypeByTypeName(String typeName);

    List<BookType> queryTypeByTid(String tid);

    void addNewType(BookType bookType);

    void deleteTypeByTid(String tid);
}
