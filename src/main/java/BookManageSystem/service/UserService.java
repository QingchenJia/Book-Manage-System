package BookManageSystem.service;

import BookManageSystem.pojo.User;

public interface UserService {
    boolean verifyUserAccount(User user);

    void addNewUser(User user);

    void updateUser(User user);
}
