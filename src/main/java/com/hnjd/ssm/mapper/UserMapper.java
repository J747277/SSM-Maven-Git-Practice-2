package com.hnjd.ssm.mapper;

import com.hnjd.ssm.domain.User;
import com.hnjd.ssm.query.QueryObject;
import com.hnjd.ssm.query.UserQueryObject;

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
     * 添加一个用户
     *
     * @param user 添加的用户
     * @return 添加结果
     */
    int insert(User user);

    /**
     * 根据条件删除
     *
     * @param userQueryObject 删除条件
     * @return 删除结果
     */
    int deleteById(QueryObject userQueryObject);


    /**
     * 更新用户
     *
     * @param u 要更新的用户
     * @return 更新结果
     */
    int update(User u);

    /**
     * 按照条件查询 可分页 登录 ID查询 分页查询 条件查询
     *
     * @param userQueryObject 查询的参数
     * @return 查询结果集
     */
    List<User> queryForList(QueryObject userQueryObject);

    /**
     * 按照条件查询数据库总记录数
     *
     * @param userQueryObject 查询的参数
     * @return 总记录数
     */
    Integer queryForCount(QueryObject userQueryObject);
}
