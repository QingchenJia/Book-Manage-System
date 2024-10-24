package BookManageSystem.service;

import BookManageSystem.pojo.entity.User;

import java.util.List;

public interface UserService {
    boolean verifyUserAccount(User user) throws Exception;

    void addNewUser(User user) throws Exception;

    void editUserInfo(User user) throws Exception;

    User getUserInfoExceptPasswd(String uid) throws Exception;

    void changePasswd(String uid, String passwd) throws Exception;

    List<User> queryAllUser();

    List<User> queryUserByUid(String uid);

    List<User> queryUserByName(String name);

    void changeBorrowDays(String uid, int borrowDays);

    void changeBorrowNum(String uid, int borrowNum);
}
