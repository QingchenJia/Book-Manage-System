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
                .withClaim("role", "user")
                .withClaim("uid", user.getUid())
                .withClaim("passwd", user.getPasswd())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .sign(Algorithm.HMAC256("LOGIN"));
    }

    public static String generateJWT4Admin(Admin admin) {
        return JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("role", "admin")
                .withClaim("aid", admin.getAid())
                .withClaim("passwd", admin.getPasswd())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .sign(Algorithm.HMAC256("LOGIN"));
    }

    public static String verifyJWT(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("LOGIN"))
                .build()
                .verify(token);

        return String.valueOf(decodedJWT.getClaim("role"));
    }
}
