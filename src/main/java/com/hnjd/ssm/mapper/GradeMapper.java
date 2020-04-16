package com.hnjd.ssm.mapper;

import com.hnjd.ssm.domain.Grade;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.mapper
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-16 12:01
 * @Description: 权限mapper规范
 */
public interface GradeMapper {
    /**
     * 查询所有权限
     *
     * @return
     */
    List<Grade> selectAll();
}
