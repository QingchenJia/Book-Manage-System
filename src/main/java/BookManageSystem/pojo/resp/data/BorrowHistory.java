package BookManageSystem.pojo.resp.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowHistory {
    private String bookName;
    private String bid;
    private Date borrowDate;
    private Date returnDate;

    public BorrowHistory() {
    }

    public BorrowHistory(String bookName, String bid, Date borrowDate, Date returnDate) {
        this.bookName = bookName;
        this.bid = bid;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowHistory{" +
                "bookName='" + bookName + '\'' +
                ", bid='" + bid + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
