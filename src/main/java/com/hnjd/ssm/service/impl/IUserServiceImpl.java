package com.hnjd.ssm.service.impl;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.mapper.UserMapper;
import com.hnjd.ssm.service.IUserService;
import com.hnjd.ssm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.service.impl
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 16:21
 * @Description: user业务实现
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User u) {
        return userMapper.insert(u);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User u) {
        return userMapper.update(u);
    }

    @Transactional(readOnly = true)
    @Override
    public User get(Long id) {
        return userMapper.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listAll() {
        //int a = 1/0;
        return userMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public void login(String username, String password) {
        User user = userMapper.login(username, password);
        if (user == null) {
            throw new RuntimeException("账号密码错误!");
        }
        UserContext.setCurrentUser(user);
    }
}
