package BookManageSystem.controller;

import BookManageSystem.pojo.User;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        } else
            return Result.error("登录失败");
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) throws Exception {
        userService.addNewUser(user);
        return Result.success("注册成功");
    }

    @PostMapping("/editInfo")
    public Result editInfo(@RequestBody User user, String newPasswd) throws Exception {
        if (userService.verifyUserAccount(user)) {
            user.setPasswd(newPasswd);
            userService.editUser(user);

            return Result.success("修改成功");
        } else
            return Result.error("密码错误");
    }

    @GetMapping("/getInfo")
    public Result getInfo(String uid) {
        User user = userService.getUserInfoExceptPasswd(uid);
        return Result.success(user);
    }
}
