package BookManageSystem.controller;

import BookManageSystem.pojo.Admin;
import BookManageSystem.pojo.resp.Result;
import BookManageSystem.service.AdminService;
import BookManageSystem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    public AdminService adminService;

    @PostMapping("/login")
    public Result login(Admin admin) {
        if (adminService.verifyAdminAccount(admin)) {
            String token = JWTUtil.generateJWT4Admin(admin);
            return Result.success("登陆成功", token);
        } else
            return Result.error("登录失败");
    }
}
