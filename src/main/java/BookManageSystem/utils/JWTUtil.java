package BookManageSystem.utils;

import BookManageSystem.pojo.Admin;
import BookManageSystem.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JWTUtil {
    public static String generateJWT4User(User user) {
        return JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("uid", user.getUid())
                .withClaim("passwd", user.getPasswd())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .sign(Algorithm.HMAC256("USER_LOGIN"));
    }

    public static User verifyJWT4User(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("USER_LOGIN"))
                .build()
                .verify(token);

        String uid = String.valueOf(decodedJWT.getClaim("uid"));
        String passwd = String.valueOf(decodedJWT.getClaim("passwd"));

        User user = new User();
        user.setUid(uid);
        user.setPasswd(passwd);

        return user;
    }

    public static String generateJWT4Admin(Admin admin) {
        return JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("aid", admin.getAid())
                .withClaim("passwd", admin.getPasswd())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .sign(Algorithm.HMAC256("ADMIN_LOGIN"));
    }

    public static Admin verifyJWT4Admin(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("ADMIN_LOGIN"))
                .build()
                .verify(token);

        String aid = String.valueOf(decodedJWT.getClaim("aid"));
        String passwd = String.valueOf(decodedJWT.getClaim("passwd"));

        Admin admin = new Admin();
        admin.setAid(aid);
        admin.setPasswd(passwd);

        return admin;
    }
}
