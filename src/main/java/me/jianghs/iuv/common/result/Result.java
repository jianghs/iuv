package me.jianghs.iuv.common.result;

import lombok.Data;
import lombok.Getter;
import me.jianghs.iuv.common.enums.ResultCode;

import java.io.Serializable;

/**
 * @className: ResultVO
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/18 9:43
 * @version: 1.0
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this(ResultCode.SUCCESS, null);
    }

    public Result(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
