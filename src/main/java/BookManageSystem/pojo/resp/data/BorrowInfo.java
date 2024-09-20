package BookManageSystem.pojo.resp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowInfo {
    private String bookName;
    private String bid;
    private Timestamp borrowDate;
    private Timestamp dueDate;
}
