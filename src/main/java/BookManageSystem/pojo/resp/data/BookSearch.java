package BookManageSystem.pojo.resp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearch {
    private String bookName;
    private String bid;
    private String author;
    private int num;
    private String press;
    private String typeName;
    private String status;
}
