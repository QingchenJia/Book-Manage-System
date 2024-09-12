package BookManageSystem.pojo.resp.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookOverview {
    private String bookName;
    private String bid;
    private String author;
    private int num;
    private String press;
    private String typeName;

    public BookOverview() {
    }

    public BookOverview(String bookName, String bid, String author, int num, String press, String typeName) {
        this.bookName = bookName;
        this.bid = bid;
        this.author = author;
        this.num = num;
        this.press = press;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookOverview{" +
                "bookName='" + bookName + '\'' +
                ", bid='" + bid + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                ", press='" + press + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
