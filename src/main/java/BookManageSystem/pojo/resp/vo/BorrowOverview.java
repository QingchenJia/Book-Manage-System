package BookManageSystem.pojo.resp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowOverview {
    private String bookName;
    private String bid;
    private String uid;
    private String userName;
    private Timestamp borrowDate;
    private Timestamp dueDate;
    private String status;
}
