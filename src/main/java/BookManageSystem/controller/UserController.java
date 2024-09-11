package BookManageSystem.controller;

import BookManageSystem.pojo.User;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        if (userService.verifyUserAccount(user)) {
            String token = JWTUtil.generateJWT4User(user);
            return Result.success("登录成功", token);
        } else return Result.error("登录失败");
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) throws Exception {
        userService.addNewUser(user);
        return Result.success("注册成功");
    }

    @PostMapping("/editInfo")
    public Result editInfo(@RequestBody Map<String, Object> params) {
        String uid = (String) params.get("uid");
        String name = (String) params.get("name");
        String email = (String) params.get("email");
        String phone = (String) params.get("phone");

        User user = new User();
        user.setUid(uid);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);

        userService.editUserInfo(user);

        return Result.success("修改成功");
    }

    @GetMapping("/getInfo")
    public Result getInfo(String uid) {
        User user = userService.getUserInfoExceptPasswd(uid);
        return Result.success(user);
    }

    @PostMapping("/changePasswd")
    public Result changePasswd(@RequestBody Map<String, Object> params) throws Exception {
        String uid = (String) params.get("uid");
        String passwd = (String) params.get("passwd");
        String newPasswd = (String) params.get("newPasswd");

        User user = new User();
        user.setUid(uid);
        user.setPasswd(passwd);

        if (userService.verifyUserAccount(user)) {
            userService.changePasswd(uid, newPasswd);
            return Result.success("修改成功");
        } else
            return Result.error("密码错误");
    }
}
