package com.hnjd.ssm.test;

import com.hnjd.ssm.query.UserQueryObject;
import com.hnjd.ssm.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.test
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-17 14:19
 * @Description: 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App {
    @Autowired
    private IUserService userService;

    @Test
    public void query4List(){
        UserQueryObject qo = new UserQueryObject();
        qo.setCurrentPage(1);
        qo.setPageSize(3);
        userService.query4List(qo);
    }
}
