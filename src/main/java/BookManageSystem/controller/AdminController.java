package BookManageSystem.controller;

import BookManageSystem.pojo.Admin;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.AdminService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    public AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) throws Exception {
        if (adminService.verifyAdminAccount(admin)) {
            String token = JWTUtil.generateJWT4Admin(admin);
            return Result.success("登陆成功", token);
        } else
            return Result.error("登录失败");
    }

    @PostMapping("/changePasswd")
    public Result changePasswd(@RequestBody Map<String, Object> params) throws Exception {
        String aid = (String) params.get("aid");
        String passwd = (String) params.get("passwd");
        String newPasswd = (String) params.get("newPasswd");

        Admin admin = new Admin(aid, passwd);

        if (adminService.verifyAdminAccount(admin)) {
            admin.setPasswd(newPasswd);
            adminService.changePasswd(admin);

            return Result.success("修改成功");
        } else
            return Result.error("密码错误");
    }

    @GetMapping("/getInfo")
    public Result getInfo(String aid) {
        Admin admin = adminService.getInfoExceptPasswd(aid);
        return Result.success(admin);
    }
}
