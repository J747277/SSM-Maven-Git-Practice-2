package com.hnjd.ssm.aop;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.util.UserContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.aop
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-16 17:39
 * @Description: 等级权限检查
 */
@Component
@Aspect
public class UserGradeCheck {

    //需要做增强的地方
    @Pointcut("execution(* com.hnjd.ssm.service.impl.IUserServiceImpl.*(..))")
    public void gradeCheckPoint() {
    }

    //在方法执行之前检查权限
    @Before("gradeCheckPoint()")
    public void check(JoinPoint joinPoint) {
        //当前增强的方法名
        String methodName = joinPoint.getSignature().getName();
        //当前登录用户
        User currentUser = UserContext.getCurrentUser();
        if (!ObjectUtils.isEmpty(currentUser)) {
            //当前登录用户的权限等级
            Long gradeId = currentUser.getGradeId().getId();
            if ("delete".contains(methodName)) {
                if (gradeId < 3) throw new RuntimeException("您是" + currentUser.getGradeId().getGradeName() + ", 权限不足!");
            } else if ("save".contains(methodName) || "update".contains(methodName)) {
                if (gradeId < 2) throw new RuntimeException("您是" + currentUser.getGradeId().getGradeName() + ", 权限不足!");
            }
        }
    }
}
