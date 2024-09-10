package BookManageSystem.pojo.resp.data;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class BorrowInfo {
    private String bookName;
    private String bid;
    private Timestamp borrowDate;
    private Timestamp dueDate;

    public BorrowInfo() {
    }

    public BorrowInfo(String bookName, String bid, Timestamp borrowDate, Timestamp dueDate) {
        this.bookName = bookName;
        this.bid = bid;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "bookName='" + bookName + '\'' +
                ", bid='" + bid + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
