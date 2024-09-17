package BookManageSystem.service;

import BookManageSystem.pojo.Admin;

public interface AdminService {
    boolean verifyAdminAccount(Admin admin) throws Exception;

    void changePasswd(Admin admin) throws Exception;

    Admin getInfo(String aid);
}
