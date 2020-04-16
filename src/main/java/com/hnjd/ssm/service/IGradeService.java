package com.hnjd.ssm.service;

import com.hnjd.ssm.domain.Grade;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.service
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-16 14:39
 * @Description: 权限业务接口
 */
public interface IGradeService {
    /**
     * 获取所有权限
     *
     * @return 权限集合
     */
    List<Grade> listAll();
}
