package com.hnjd.ssm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @BelongsProject: SSMMavenGitPractice1
 * @BelongsPackage: com.hnjd.ssm.domain
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-13 15:00
 * @Description: user实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    @NotNull(message="用户名不能为空")
    private String username;
    @NotNull(message="密码不能为空")
    @Size(min = 2,max = 4,message="密码必须为2到4个字符")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date bornDate;
    private String headImg;
}
