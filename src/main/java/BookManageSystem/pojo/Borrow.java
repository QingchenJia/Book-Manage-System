package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Borrow {
    private String bid;
    private String uid;
    private Timestamp borrowDate;
    private Timestamp dueDate;
    private Timestamp returnDate;
    private int isReturn;

    public Borrow() {
    }

    public Borrow(String bid, String uid, Timestamp borrowDate, Timestamp dueDate, Timestamp returnDate, int isReturn) {
        this.bid = bid;
        this.uid = uid;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.isReturn = isReturn;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "bid='" + bid + '\'' +
                ", uid='" + uid + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", isReturn=" + isReturn +
                '}';
    }
}
