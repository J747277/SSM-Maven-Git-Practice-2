package com.hnjd.ssm.mapper;

import com.hnjd.ssm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.mapper
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 15:07
 * @Description: usermapper
 */
public interface UserMapper {
    int insert(User u);

    int deleteById(Long id);

    int update(User u);

    User getById(Long id);

    List<User> selectAll();

    User login(@Param("username") String username, @Param("password") String password);
}
