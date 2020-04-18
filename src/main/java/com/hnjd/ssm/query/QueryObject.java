package com.hnjd.ssm.query;

import lombok.Data;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.query
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-18 18:26
 * @Description: 查询操作共有的属性
 */
@Data
public class QueryObject {
    private Integer currentPage = 1;//当前页  默认第一页
    private Integer pageSize = 4;//每页最多多少条数据  默认5条

    /**
     * 从第几页开始查
     *
     * @return
     */
    public Integer getStart() {
        return currentPage >= 1 ? (currentPage - 1) * pageSize : 0;
    }
}
