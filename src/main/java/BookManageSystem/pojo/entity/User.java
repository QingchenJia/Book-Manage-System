package BookManageSystem.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String uid;
    private String passwd;
    private String name;
    private String email;
    private String phone;
    private int borrowNum;
    private int borrowDays;
}
