package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 9:20 下午
 * 借助此对象封装数据层返回的分页查询结果,并计算分页信息
 */

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {

    private static final long serialVersionUID = 1733756717947416014L;
    /**
     * 封装查询到的当前页记录
     */
    private List<T> records;

    /**
     * 总记录数
     */
    private Long rowCount;

    /**
     * 总页数
     */
    private Long pageCount;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前页码值
     */
    private Long pageCurrent;

    public PageObject(List<T> records, Long rowCount, Integer pageSize, Long pageCurrent) {
        this.records = records;
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageCount = (rowCount - 1) / pageSize + 1;
    }
}
