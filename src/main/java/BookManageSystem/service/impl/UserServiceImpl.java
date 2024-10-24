package BookManageSystem.service.impl;

import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.entity.User;
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
        parsePasswd(user);
        return userMapper.selectByUidAndPasswd(user) != null;
    }

    @Override
    public void addNewUser(User user) throws Exception {
        parsePasswd(user);
        userMapper.insertUser(user);
    }

    @Override
    public void editUserInfo(User user) throws Exception {
        parseInfo(user);
        userMapper.updateUser(user);
    }

    @Override
    public User getUserInfoExceptPasswd(String uid) throws Exception {
        User user = userMapper.selectByUid(uid);
        user.setPasswd(null);

        processInfo(user);

        return user;
    }

    @Override
    public void changePasswd(String uid, String passwd) throws Exception {
        String decrypt = CipherUtil.decrypt(passwd);
        String sha256 = CipherUtil.hashSHA256(decrypt);
        userMapper.updatePasswdByUid(uid, sha256);
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

    private void parsePasswd(User user) throws Exception {
        String decrypt = CipherUtil.decrypt(user.getPasswd());
        String sha256 = CipherUtil.hashSHA256(decrypt);
        user.setPasswd(sha256);
    }

    private void parseInfo(User user) throws Exception {
        String decryptName = CipherUtil.decrypt(user.getName());
        String decryptEmail = CipherUtil.decrypt(user.getEmail());
        String decryptPhone = CipherUtil.decrypt(user.getPhone());

        user.setName(decryptName);
        user.setEmail(decryptEmail);
        user.setPhone(decryptPhone);
    }

    private void processInfo(User user) throws Exception {
        // 加密基本信息，发送给前端解密
        String encryptName = CipherUtil.encrypt(user.getName());
        String encryptEmail = CipherUtil.encrypt(user.getEmail());
        String encryptPhone = CipherUtil.encrypt(user.getPhone());

        user.setName(encryptName);
        user.setEmail(encryptEmail);
        user.setPhone(encryptPhone);
    }
}
