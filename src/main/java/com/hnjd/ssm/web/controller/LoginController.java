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
 * @Description:
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
            session.setAttribute("errorMsg", e.getMessage());
            return "redirect:/login.jsp";
        }
        return "redirect:/user/list";
    }
}
