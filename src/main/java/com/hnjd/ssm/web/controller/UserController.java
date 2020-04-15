package com.hnjd.ssm.web.controller;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.web.controller
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 17:23
 * @Description: user控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    @RequestMapping("/input")
    public String input(Long id,Model model){
        if(id != null){
            model.addAttribute("user",userService.get(id));
        }else{
            model.addAttribute("user",new User());
        }
        return "user/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@Validated User user , BindingResult bindingResult ,Model model){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(allErrors.size() > 0){
            model.addAttribute("errors" ,allErrors);
            return "user/input";
        }
        userService.save(user);
        return "redirect:/user/list";
    }
}