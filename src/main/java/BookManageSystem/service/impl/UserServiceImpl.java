package BookManageSystem.service.impl;

import BookManageSystem.mapper.UserMapper;
import BookManageSystem.pojo.User;
import BookManageSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public boolean verifyUserAccount(User user) {
        return userMapper.selectByUidAndPasswd(user) != null;
    }
}
