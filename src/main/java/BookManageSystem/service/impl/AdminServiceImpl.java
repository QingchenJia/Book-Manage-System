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
        parsePasswd(admin);
        return adminMapper.selectByAidAndPasswd(admin) != null;
    }

    @Override
    public void changePasswd(Admin admin) throws Exception {
        parsePasswd(admin);
        adminMapper.updatePasswd(admin);
    }

    @Override
    public Admin getInfoExceptPasswd(String aid) {
        Admin admin = adminMapper.selectByAid(aid);
        admin.setPasswd(null);

        return admin;
    }

    private void parsePasswd(Admin admin) throws Exception {
        // 将前端传递的密文解密，再进行哈希
        String decrypt = CipherUtil.decrypt(admin.getPasswd());
        String sha256 = CipherUtil.hashSHA256(decrypt);
        admin.setPasswd(sha256);
    }
}
