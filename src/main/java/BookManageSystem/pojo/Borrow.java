package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class Borrow {
    private String bid;
    private String uid;
    private Date borrowDate;
    private Date returnDate;
    private int isReturn;

    public Borrow() {
    }

    public Borrow(String bid, String uid, Date borrowDate, Date returnDate, int isReturn) {
        this.bid = bid;
        this.uid = uid;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturn = isReturn;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "bid='" + bid + '\'' +
                ", uid='" + uid + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", isReturn=" + isReturn +
                '}';
    }
}
