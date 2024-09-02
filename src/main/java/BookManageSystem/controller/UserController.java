package BookManageSystem.controller;

import BookManageSystem.pojo.User;
import BookManageSystem.pojo.tool.Result;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public Result login(User user) {
        if (userService.verifyUserAccount(user)) {
            String token = JWTUtil.generateJWT(user);
            return Result.success("登录成功!", token);
        } else
            return Result.error("登录失败!");
    }
}