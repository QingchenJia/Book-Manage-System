package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookType {
    private String tid;
    private String typeName;

    public BookType() {
    }

    public BookType(String tid, String typeName) {
        this.tid = tid;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "tid='" + tid + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
