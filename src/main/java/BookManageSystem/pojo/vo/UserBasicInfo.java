package BookManageSystem.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBasicInfo {
    private String uid;
    private String name;
    private String email;
    private String phone;
}
