package BookManageSystem.service;

import BookManageSystem.pojo.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> queryAllBorrow();

    List<Borrow> queryBorrowByBookName(String bookName);

    List<Borrow> queryBorrowByUid(String uid);

    List<Borrow> queryBorrowByUserName(String userName);

    List<Borrow> queryBorrowByBid(String bid);

    List<Borrow> queryMyAllBorrow(String uid);

    List<Borrow> queryMyBorrowByBookName(String uid, String bookName);

    Borrow queryMyBorrowByBid(String uid, String bid);
}
