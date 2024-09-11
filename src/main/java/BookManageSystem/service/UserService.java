package BookManageSystem.service;

import BookManageSystem.pojo.User;

public interface UserService {
    boolean verifyUserAccount(User user) throws Exception;

    void addNewUser(User user) throws Exception;

    void editUserInfo(User user);

    User getUserInfoExceptPasswd(String uid);

    void changePasswd(String uid, String passwd) throws Exception;
}
