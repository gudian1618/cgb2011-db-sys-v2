package com.github.gudian1618.cgb2011dbsysv2.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/30 11:09 上午
 */

@Data
public class Node implements Serializable {

    private static final long serialVersionUID = 2070237976355752821L;
    private Integer id;
    private String name;
    private Integer parentId;

}
