package com.hnjd.ssm.web.controller;

import com.hnjd.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.web.controller
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-14 17:41
 * @Description: 用户登录控制器
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        try {
            userService.login(username, password);
        } catch (Exception e) {
            //若用户登录失败则将抛出异常,捕获异常之后附带异常信息重定向到登录页面
            session.setAttribute("errorMsg", e.getMessage());
            return "redirect:/login.jsp";
        }
        return "redirect:/user/list";
    }
}
