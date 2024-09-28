package BookManageSystem.pojo.resp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowHistory {
    private String bookName;
    private String bid;
    private Timestamp borrowDate;
    private Timestamp returnDate;
}
