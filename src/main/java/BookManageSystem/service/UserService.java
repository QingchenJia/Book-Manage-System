package BookManageSystem.service;

import BookManageSystem.pojo.User;

public interface UserService {
    boolean verifyUserAccount(User user) throws Exception;

    void addNewUser(User user) throws Exception;

    void updateUser(User user) throws Exception;
}
