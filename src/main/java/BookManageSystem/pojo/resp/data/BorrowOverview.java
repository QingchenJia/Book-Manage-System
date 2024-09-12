package BookManageSystem.pojo.resp.data;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class BorrowOverview {
    private String bookName;
    private String bid;
    private String uid;
    private String name;
    private Timestamp borrowDate;
    private Timestamp dueDate;
    private String status;

    public BorrowOverview() {
    }

    public BorrowOverview(String bookName, String bid, String uid, String name, Timestamp borrowDate, Timestamp dueDate, String status) {
        this.bookName = bookName;
        this.bid = bid;
        this.uid = uid;
        this.name = name;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowOverview{" +
                "bookName='" + bookName + '\'' +
                ", bid='" + bid + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
