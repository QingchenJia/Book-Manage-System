package BookManageSystem.service;

import BookManageSystem.pojo.entity.Admin;

public interface AdminService {
    boolean verifyAdminAccount(Admin admin) throws Exception;

    void changePasswd(Admin admin) throws Exception;

    Admin getInfoExceptPasswd(String aid);
}
