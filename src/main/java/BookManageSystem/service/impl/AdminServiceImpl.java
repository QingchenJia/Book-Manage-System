package BookManageSystem.service.impl;

import BookManageSystem.mapper.AdminMapper;
import BookManageSystem.pojo.entity.Admin;
import BookManageSystem.service.AdminService;
import BookManageSystem.utils.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;

    @Override
    public boolean verifyAdminAccount(Admin admin) throws Exception {
        passwd2ciphertext(admin);
        return adminMapper.selectByAidAndPasswd(admin) != null;
    }

    @Override
    public void changePasswd(Admin admin) throws Exception {
        passwd2ciphertext(admin);
        adminMapper.updatePasswd(admin);
    }

    @Override
    public Admin getInfoExceptPasswd(String aid) {
        Admin admin = adminMapper.selectByAid(aid);
        admin.setPasswd(null);

        return admin;
    }

    private void passwd2ciphertext(Admin admin) throws Exception {
        String ciphertext = CipherUtil.encrypt(admin.getPasswd());
        admin.setPasswd(ciphertext);
    }
}
