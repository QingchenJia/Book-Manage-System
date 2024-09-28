package BookManageSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
    private String bid;
    private String bookName;
    private String author;
    private int num;
    private String press;
    private String tid;
    private int isDelete;
}
