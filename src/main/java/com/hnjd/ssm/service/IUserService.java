package com.hnjd.ssm.service;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.query.PageResult;
import com.hnjd.ssm.query.QueryObject;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.service
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 16:19
 * @Description: user业务接口
 */
public interface IUserService {
    /**
     * 保存一个用户
     *
     * @param u 用户对象
     * @return 保存结果
     */
    int save(User u);

    /**
     * 根据id删除一个用户
     *
     * @param ids 用户删除的id
     * @return 删除结果
     */
    int delete(String[] ids);

    /**
     * 更新一个用户
     *
     * @param u 用户对象
     * @return 更新结果
     */
    int update(User u);

    /**
     * 根据id获取一位用户
     *
     * @param id 用户id
     * @return 获取的用户
     */
    User get(Long id);

    /**
     * 获取所有用户
     *
     * @return PageResult
     */
    PageResult query4List(QueryObject userQueryObject);

    /**
     * 用户登录
     *
     * @param username 账号
     * @param password 密码
     * @return 登录后的用户
     */
    void login(String username, String password);
}