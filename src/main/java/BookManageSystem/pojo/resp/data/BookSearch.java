package BookManageSystem.pojo.resp.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookSearch {
    private String bookName;
    private String bid;
    private String author;
    private int num;
    private String press;
    private String typeName;
    private String status;

    public BookSearch() {
    }

    public BookSearch(String bookName, String bid, String author, int num, String press, String typeName, String status) {
        this.bookName = bookName;
        this.bid = bid;
        this.author = author;
        this.num = num;
        this.press = press;
        this.typeName = typeName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookSearch{" +
                "bookName='" + bookName + '\'' +
                ", bid='" + bid + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                ", press='" + press + '\'' +
                ", typeName='" + typeName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
