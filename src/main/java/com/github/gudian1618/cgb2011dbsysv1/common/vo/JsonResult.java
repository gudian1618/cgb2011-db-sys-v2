package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/24 9:30 下午
 * 最后生成序列化的ID值
 */

@Data
@NoArgsConstructor
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -8085470595304834154L;
    private int state=1;
    private String message = "ok";
    private Object data;

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable e) {
        this.state = 0;
        this.message = e.getMessage();
    }
}
