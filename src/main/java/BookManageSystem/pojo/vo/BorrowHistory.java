package BookManageSystem.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowHistory {
    private String bookName;
    private String bid;
    private Timestamp borrowDate;
    private Timestamp returnDate;
}
