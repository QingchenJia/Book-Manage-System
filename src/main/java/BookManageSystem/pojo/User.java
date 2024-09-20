package BookManageSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String passwd;
    private String name;
    private String email;
    private String phone;
    private int borrowNum;
    private int borrowDays;
}
