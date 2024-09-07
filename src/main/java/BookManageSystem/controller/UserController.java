package BookManageSystem.controller;

import BookManageSystem.pojo.User;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (userService.verifyUserAccount(user)) {
            String token = JWTUtil.generateJWT4User(user);
            return Result.success("登录成功", token);
        } else
            return Result.error("登录失败");
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.addNewUser(user);
        return Result.success("注册成功");
    }
}
