package com.hnjd.ssm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.exception
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-14 22:03
 * @Description:
 */
@ControllerAdvice
public class HandleExceptionAdvice {

    @ExceptionHandler
    public String error(Exception ex,Model model){
        model.addAttribute("errorMsg",ex);
        return "commons/error";
    }
}
