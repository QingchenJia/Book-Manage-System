package BookManageSystem.service.impl;

import BookManageSystem.mapper.BorrowMapper;
import BookManageSystem.pojo.Borrow;
import BookManageSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    public BorrowMapper borrowMapper;

    @Override
    public List<Borrow> queryAllBorrow() {
        return borrowMapper.selectAll();
    }

    @Override
    public List<Borrow> queryBorrowByBookName(String bookName) {
        return borrowMapper.selectByBookName(bookName);
    }

    @Override
    public List<Borrow> queryBorrowByUid(String uid) {
        return borrowMapper.selectByUid(uid);
    }

    @Override
    public List<Borrow> queryBorrowByUserName(String userName) {
        return borrowMapper.selectByUserName(userName);
    }

    @Override
    public List<Borrow> queryBorrowByBid(String bid) {
        return borrowMapper.selectByBid(bid);
    }
}
