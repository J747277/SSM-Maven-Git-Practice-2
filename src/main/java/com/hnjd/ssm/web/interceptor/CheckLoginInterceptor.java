package com.hnjd.ssm.web.interceptor;

import com.hnjd.ssm.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.web.interceptor
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-14 18:33
 * @Description: 登录拦截器 检查用户是否已登录
 */
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //若当前无用户登录则重定向到登录页面
        if (UserContext.getCurrentUser() == null) {
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;//否则放行
    }
}
