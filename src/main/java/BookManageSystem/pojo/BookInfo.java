package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookInfo {
    private String bid;
    private String bookName;
    private String author;
    private int num;
    private String press;
    private String tid;
    private int status;

    public BookInfo() {
    }

    public BookInfo(String bid, String bookName, String author, int num, String press, String tid, int status) {
        this.bid = bid;
        this.bookName = bookName;
        this.author = author;
        this.num = num;
        this.press = press;
        this.tid = tid;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bid='" + bid + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                ", press='" + press + '\'' +
                ", tid='" + tid + '\'' +
                ", status=" + status +
                '}';
    }
}
