package com.hnjd.ssm.query;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.query
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-17 12:06
 * @Description: 用户查询参数封装
 */
@Data
public class UserQueryObject extends QueryObject {
    private Long id;//用户修改时用的id

    //用户登录时用的账号和密码
    private String username;
    private String password;

    //删除多个
    private String[] deleteAll;

    private String keyword;//关键字查询
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;//结束时间
    private BigDecimal minSalary;//最低工资
    private BigDecimal maxSalary; //最高工资
    private Integer gradeId;//权限等级

    private Integer search;//判断是否是条件查询

    /**
     * 关键字不能为空字符串
     *
     * @return
     */
    public String getKeyword() {
        return ("".trim()).equals(keyword) ? null : keyword;
    }
}
