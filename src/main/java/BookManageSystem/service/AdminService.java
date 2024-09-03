package BookManageSystem.service;

import BookManageSystem.pojo.Admin;

public interface AdminService {
    boolean verifyAdminAccount(Admin admin);

    void changePasswd(Admin admin);
}
