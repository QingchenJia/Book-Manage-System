package BookManageSystem.service;

import BookManageSystem.pojo.User;

public interface UserService {
    boolean verifyUserAccount(User user) throws Exception;

    void addNewUser(User user) throws Exception;

    void editUser(User user) throws Exception;

    User getUserInfoExceptPasswd(String uid);
}
