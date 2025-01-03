package BookManageSystem.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookInfo {
    private String bid;
    private String bookName;
    private String author;
    private int num;
    private String press;
    private String tid;
    private int isDelete;
}
