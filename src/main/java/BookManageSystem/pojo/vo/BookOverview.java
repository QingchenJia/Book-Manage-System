package BookManageSystem.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookOverview {
    private String bookName;
    private String bid;
    private String author;
    private int num;
    private String press;
    private String typeName;
}
