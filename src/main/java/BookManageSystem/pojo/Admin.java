package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {
    private String aid;
    private String passwd;

    public Admin() {
    }

    public Admin(String aid, String passwd) {
        this.aid = aid;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
