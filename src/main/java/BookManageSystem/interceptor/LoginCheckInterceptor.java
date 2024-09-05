package BookManageSystem.interceptor;

import BookManageSystem.pojo.respdata.Result;
import BookManageSystem.utils.JSONUtil;
import BookManageSystem.utils.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            log.info("离线访问");
            errorToken(response);

            return false;
        }

        String role = request.getParameter("role");
        if ("user".equals(role)) {
            try {
                JWTUtil.verifyJWT4User(token);
            } catch (Exception e) {
                log.info("令牌失效");
                errorToken(response);

                return false;
            }
        } else if ("admin".equals(role)) {
            try {
                JWTUtil.verifyJWT4Admin(token);
            } catch (Exception e) {
                log.info("令牌失效");
                errorToken(response);

                return false;
            }
        }

        log.info("令牌合法");
        return true;
    }

    private void errorToken(HttpServletResponse response) throws IOException {
        Result error = Result.error("离线访问");
        String notLogin = JSONUtil.object2JSON(error);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(notLogin);
    }
}