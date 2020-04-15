package com.hnjd.ssm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.exception
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-14 22:03
 * @Description: 抛出异常则进入commons/error.jsp显示异常
 */
@ControllerAdvice
public class HandleExceptionAdvice {

    @ExceptionHandler
    public String error(Exception ex, Model model) {
        model.addAttribute("errorMsg", ex);//显示的错误信息
        return "commons/error";
    }
}
