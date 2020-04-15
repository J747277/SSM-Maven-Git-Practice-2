package com.hnjd.ssm.service;

import com.hnjd.ssm.domain.User;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.service
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 16:19
 * @Description: user业务接口
 */
public interface IUserService {
    int save(User u);

    int delete(Long id);

    int update(User u);

    User get(Long id);

    List<User> listAll();

    void login(String username, String password);
}