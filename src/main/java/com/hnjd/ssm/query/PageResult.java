package com.hnjd.ssm.query;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @BelongsProject: SSMMavenGitPractice2
 * @BelongsPackage: com.hnjd.ssm.util
 * @Author: Jiang Haiming
 * @CreateTime: 2020-04-17 00:07
 * @Description: 封装分页查询
 */
@Getter
@Setter
public class PageResult extends QueryObject {
    private List result;//分页查询结果集
    private Integer totalCount;//数据库总记录数
    private Integer totalPage;//总页数
    private Integer prevPage;//上一页
    private Integer nextPage;//下一页

    /**
     * 使用构造器封装分页查询结果集
     *
     * @param result      查询的结果集
     * @param totalCount  数据库总记录数
     * @param currentPage 当前页
     * @param pageSize    每页对多几条数据
     */
    public PageResult(List result, Integer totalCount, int currentPage, int pageSize) {
        super();
        this.result = result;
        this.totalCount = totalCount;
        //若totalCount除以pageSize有余数, 则将最大页数加一
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        //上一页最小为1
        this.prevPage = currentPage - 1 <= 1 ? 1 : currentPage - 1;
        //下一页最大为总页数
        this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
    }
}
