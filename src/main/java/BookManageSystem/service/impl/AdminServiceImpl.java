package BookManageSystem.service.impl;

import BookManageSystem.mapper.AdminMapper;
import BookManageSystem.pojo.Admin;
import BookManageSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;

    @Override
    public boolean verifyAdminAccount(Admin admin) {
        return adminMapper.searchByAidAndPasswd(admin) != null;
    }

    @Override
    public void changePasswd(Admin admin) {
        adminMapper.updatePasswd(admin);
    }
}
