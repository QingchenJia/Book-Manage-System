package BookManageSystem.service.impl;

import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.User;
import BookManageSystem.service.UserService;
import BookManageSystem.utils.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private void passwd2ciphertext(User user) throws Exception {
        String ciphertextPasswd = CipherUtil.encrypt(user.getPasswd());
        user.setPasswd(ciphertextPasswd);
    }
}
