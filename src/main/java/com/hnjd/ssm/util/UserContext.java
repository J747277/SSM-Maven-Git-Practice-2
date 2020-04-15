package com.hnjd.ssm.util;

import com.hnjd.ssm.domain.User;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.util
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-14 18:42
 * @Description: 封装当前登录用户的上下文信息
 */
public class UserContext {
    private static final String USER_IN_SESSION = "user_in_session";

    /**
     * 获取httpSession
     *
     * @return httpSession
     */
    private static HttpSession getSession() {
        return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    /**
     * 将用户存入session
     *
     * @param currentUser
     */
    public static void setCurrentUser(User currentUser) {
        //登录查询成功之后将用户存入session否则销毁session
        if (ObjectUtils.isEmpty(currentUser)) {
            getSession().invalidate();
        } else {
            getSession().setAttribute(USER_IN_SESSION, currentUser);
        }
    }

    /**
     * 获取当前登录用户
     *
     * @return 当前登录用户
     */
    public static User getCurrentUser() {
        return (User) getSession().getAttribute(USER_IN_SESSION);
    }
}
