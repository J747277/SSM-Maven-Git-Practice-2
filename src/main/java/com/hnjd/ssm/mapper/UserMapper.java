package com.hnjd.ssm.mapper;

import com.hnjd.ssm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.mapper
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 15:07
 * @Description: usermapper接口
 */
public interface UserMapper {

    /**
     * 保存一个用户
     *
     * @param u 用户对象
     * @return 保存结果
     */
    int insert(User u);

    /**
     * 根据id删除一个用户
     *
     * @param id 用户id
     * @return 删除结果
     */
    int deleteById(Long id);

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
    User getById(Long id);

    /**
     * 获取所有用户
     *
     * @return 用户集合
     */
    List<User> selectAll();

    /**
     * 用户登录
     * @param username 账号
     * @param password 密码
     * @return 登录后的用户
     */
    User login(@Param("username") String username, @Param("password") String password);
}
