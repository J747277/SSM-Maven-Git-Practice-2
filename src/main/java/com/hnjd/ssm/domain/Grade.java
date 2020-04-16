package com.hnjd.ssm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.domain
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-16 11:59
 * @Description: 权限类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private Long id;//权限唯一标识
    private String gradeName;//权限名称
}
