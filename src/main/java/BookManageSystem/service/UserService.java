package BookManageSystem.service;

import BookManageSystem.pojo.User;

import java.util.List;

public interface UserService {
    boolean verifyUserAccount(User user) throws Exception;

    void addNewUser(User user) throws Exception;

    void editUserInfo(User user);

    User getUserInfoExceptPasswd(String uid);

    void changePasswd(String uid, String passwd) throws Exception;

    List<User> queryAllUser();

    List<User> queryUserByUid(String uid);

    List<User> queryUserByName(String name);

    void changeBorrowDays(String uid, int borrowDays);

    void changeBorrowNum(String uid, int borrowNum);
}
