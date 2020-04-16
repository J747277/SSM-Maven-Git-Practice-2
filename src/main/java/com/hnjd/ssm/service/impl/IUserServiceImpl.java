package com.hnjd.ssm.service.impl;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.mapper.UserMapper;
import com.hnjd.ssm.service.IUserService;
import com.hnjd.ssm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @Autowired
    private ServletContext servletContext;

    @Override
    public int save(User u) {
        return userMapper.insert(u);
    }

    @Override
    public int delete(Long id) {
        //删除用户前若该用户存在用户头像则先将用户头像图片删除
        User user = userMapper.getById(id);
        String headImg = user.getHeadImg();
        if (!StringUtils.isEmpty(headImg) && !"defaultHeadImg.png".equals(user.getHeadImg())) {
            try {
                Files.deleteIfExists(Paths.get(servletContext.getRealPath("images/headImg/" + headImg)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        //若登录后的对象为null则抛出异常
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("账号密码错误!");
        }
        UserContext.setCurrentUser(user);
    }
}
