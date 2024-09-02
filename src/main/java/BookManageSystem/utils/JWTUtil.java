package BookManageSystem.utils;

import BookManageSystem.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JWTUtil {
    public static String generateJWT(User user) {
        return JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("uid", user.getUid())
                .withClaim("passwd", user.getPasswd())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .sign(Algorithm.HMAC256("qingchenjia"));
    }

    public static User verifyJWT(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("qingchenjia"))
                .build()
                .verify(token);

        String uid = String.valueOf(decodedJWT.getClaim("uid"));
        String passwd = String.valueOf(decodedJWT.getClaim("passwd"));

        User user = new User();
        user.setUid(uid);
        user.setPasswd(passwd);

        return user;
    }
}
