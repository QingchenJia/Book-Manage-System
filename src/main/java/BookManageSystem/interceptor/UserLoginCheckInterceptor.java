package BookManageSystem.interceptor;

import BookManageSystem.pojo.tool.Result;
import BookManageSystem.utils.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class UserLoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            log.info("离线访问");
            Result error = Result.error("Not_Login");
            String notLogin = JSONUtil.object2JSON(error);
            response.getWriter().write(notLogin);

            return false;
        }

        log.info("令牌合法");
        return true;
    }
}
