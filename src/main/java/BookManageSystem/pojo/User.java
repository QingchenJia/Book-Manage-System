package BookManageSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String uid;
    private String passwd;
    private String name;
    private String email;
    private String phone;
    private String borrowNum;
    private String borrowDays;

    public User() {
    }

    public User(String uid, String passwd, String name, String email, String phone, String borrowNum, String borrowDays) {
        this.uid = uid;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowNum = borrowNum;
        this.borrowDays = borrowDays;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", borrowNum='" + borrowNum + '\'' +
                ", borrowDays='" + borrowDays + '\'' +
                '}';
    }
}
