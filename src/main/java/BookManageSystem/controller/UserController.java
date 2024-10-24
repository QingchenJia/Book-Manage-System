package BookManageSystem.controller;

import BookManageSystem.common.Result;
import BookManageSystem.pojo.entity.User;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        } else
            return Result.error("登录失败");
    }


    @PostMapping("/register")
    public Result register(@RequestBody User user) throws Exception {
        userService.addNewUser(user);
        return Result.success("注册成功");
    }

    @PostMapping("/editInfo")
    public Result editInfo(@RequestBody Map<String, Object> params) throws Exception {
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
    public Result getInfo(String uid) throws Exception {
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

    @GetMapping("/queryAllUser")
    public Result queryAllUser() {
        List<User> users = userService.queryAllUser();
        return Result.success(users);
    }

    @GetMapping("/queryUserByUid")
    public Result queryUserByUid(String uid) {
        List<User> users = userService.queryUserByUid(uid);
        return Result.success(users);
    }

    @GetMapping("/queryUserByName")
    public Result queryUserByName(String name) {
        List<User> users = userService.queryUserByName(name);
        return Result.success(users);
    }

    @PostMapping("/changeBorrowNum")
    public Result changeBorrowPower(@RequestBody Map<String, Object> params) {
        // 修改用户的借阅权限 借阅天数和借阅本数
        String uid = (String) params.get("uid");
        Object bd = params.get("borrowDays");
        Object bn = params.get("borrowNum");

        if (bd != null) {
            int borrowDays = (int) bd;
            userService.changeBorrowDays(uid, borrowDays);
        }

        if (bn != null) {
            int borrowNum = (int) bn;
            userService.changeBorrowNum(uid, borrowNum);
        }

        return Result.success("修改成功");
    }

    @PostMapping("/resetPasswd")
    public Result resetPasswd(@RequestBody Map<String, Object> params) throws Exception {
        String uid = (String) params.get("uid");
        userService.changePasswd(uid, "8J9Je8e093V8Jiu+ily0yQ==");  // 重置密码为：123456

        return Result.success("重置成功");
    }
}
