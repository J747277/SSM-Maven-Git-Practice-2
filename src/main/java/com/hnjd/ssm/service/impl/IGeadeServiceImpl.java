package com.hnjd.ssm.service.impl;

import com.hnjd.ssm.domain.Grade;
import com.hnjd.ssm.mapper.GradeMapper;
import com.hnjd.ssm.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.service.impl
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-16 14:41
 * @Description:
 */
@Service
@Transactional
public class IGeadeServiceImpl implements IGradeService {

    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 获取所有权限
     *
     * @return 权限集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Grade> listAll() {
        return gradeMapper.selectAll();
    }
}
