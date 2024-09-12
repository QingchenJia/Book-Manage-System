package BookManageSystem.service.impl;

import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.User;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public boolean verifyUserAccount(User user) throws Exception {
        passwd2ciphertext(user);
        return userMapper.selectByUidAndPasswd(user) != null;
    }

    @Override
    public void addNewUser(User user) throws Exception {
        passwd2ciphertext(user);
        userMapper.insertUser(user);
    }

    @Override
    public void editUserInfo(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserInfoExceptPasswd(String uid) {
        User user = userMapper.selectByUid(uid);
        user.setPasswd(null);

        return user;
    }

    @Override
    public void changePasswd(String uid, String passwd) throws Exception {
        String ciphertext = CipherUtil.encrypt(passwd);
        userMapper.updatePasswdByUid(uid, ciphertext);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> queryUserByUid(String uid) {
        User user = userMapper.selectByUid(uid);
        List<User> users = new ArrayList<>();
        users.add(user);

        return users;
    }

    @Override
    public List<User> queryUserByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public void changeBorrowDays(String uid, int borrowDays) {
        userMapper.updateBorrowDaysByUid(uid, borrowDays);
    }

    @Override
    public void changeBorrowNum(String uid, int borrowNum) {
        userMapper.updateBorrowNumByUid(uid, borrowNum);
    }

    private void passwd2ciphertext(User user) throws Exception {
        String ciphertextPasswd = CipherUtil.encrypt(user.getPasswd());
        user.setPasswd(ciphertextPasswd);
    }
}
