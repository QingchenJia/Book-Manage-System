package BookManageSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private String bid;
    private String uid;
    private Timestamp borrowDate;
    private Timestamp dueDate;
    private Timestamp returnDate;
    private int isReturn;
}
