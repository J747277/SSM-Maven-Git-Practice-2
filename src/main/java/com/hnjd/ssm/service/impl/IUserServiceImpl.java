package com.hnjd.ssm.service.impl;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.mapper.UserMapper;
import com.hnjd.ssm.query.PageResult;
import com.hnjd.ssm.query.QueryObject;
import com.hnjd.ssm.query.UserQueryObject;
import com.hnjd.ssm.service.IUserService;
import com.hnjd.ssm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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
    public int delete(String[] ids) {
        UserQueryObject uqo = new UserQueryObject();
        uqo.setDeleteAll(ids);
        //删除用户前若该用户存在用户头像则先将用户头像图片删除
        List<User> users = this.query4List(uqo).getResult();
        if (!CollectionUtils.isEmpty(users)) {
            for (User user : users) {
                String headImg = user.getHeadImg();
                if (!StringUtils.isEmpty(headImg) && !"defaultHeadImg.png".equals(user.getHeadImg())) {
                    try {
                        Files.deleteIfExists(Paths.get(servletContext.getRealPath("images/headImg/" + headImg)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return userMapper.deleteById(uqo);
    }

    @Override
    public int update(User u) {
        return userMapper.update(u);
    }

    @Transactional(readOnly = true)
    @Override
    public User get(Long id) {
        if (!ObjectUtils.isEmpty(id)) {
            UserQueryObject uqo = new UserQueryObject();
            uqo.setId(id);
            List<User> users = userMapper.queryForList(uqo);
            if (!CollectionUtils.isEmpty(users)) {
                return users.get(0);
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult query4List(QueryObject userQueryObject) {
        Integer rows = userMapper.queryForCount(userQueryObject);
        if (rows == 0) {
            return new PageResult(Collections.EMPTY_LIST, 0, 1, userQueryObject.getPageSize());
        }
        PageResult pageResult = new PageResult(null, rows, userQueryObject.getCurrentPage(), userQueryObject.getPageSize());
        //保证当前页始终不能比总页数大
        if (userQueryObject.getCurrentPage() > pageResult.getTotalPage()) {
            userQueryObject.setCurrentPage(pageResult.getTotalPage());
        }
        List<User> users = userMapper.queryForList(userQueryObject);
        pageResult.setResult(users);
        return pageResult;
        //int a = 1/0;
    }

    @Transactional(readOnly = true)
    @Override
    public void login(String username, String password) {
        UserQueryObject uqo = new UserQueryObject();
        uqo.setUsername(username);
        uqo.setPassword(password);
        List<User> users = userMapper.queryForList(uqo);
        //若登录后的对象为null则抛出异常
        if (CollectionUtils.isEmpty(users)) {
            throw new RuntimeException("账号密码错误!");
        }
        UserContext.setCurrentUser(users.get(0));
    }
}
