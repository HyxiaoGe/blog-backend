package com.hyxiao.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:24
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    // 响应业务状态码
    private Integer status;

    // 响应消息
    private String msg;

    // 是否成功
    private Boolean success;

    // 响应数据，可以是Object，也可以是List或Map等
    private Object data;

    /**
     * 成功返回，带有数据的，直接往OK方法丢data数据即可
     * @param data
     * @return
     */
    public static BaseResponse success(Object data) {
        return new BaseResponse(data);
    }

    /**
     * 成功返回，不带有数据的，直接调用ok方法，data无须传入（其实就是null）
     * @return
     */
    public static BaseResponse success() {
        return new BaseResponse(ResponseStatusCode.SUCCESS);
    }

    public BaseResponse(Object data) {
        this.status = ResponseStatusCode.SUCCESS.status();
        this.msg = ResponseStatusCode.SUCCESS.msg();
        this.success = ResponseStatusCode.SUCCESS.success();
        this.data = data;
    }

    /**
     * 错误返回，直接调用failure方法即可，当然也可以在ResponseStatusEnum中自定义错误后再返回也都可以
     * @return
     */
    public static BaseResponse failure() {
        return new BaseResponse(ResponseStatusCode.FAILED);
    }

    /**
     * 错误返回，map中包含了多条错误信息，可以用于表单验证，把错误统一的全部返回出去
     * @param map
     * @return
     */
    public static BaseResponse failureMap(Map map) {
        return new BaseResponse(ResponseStatusCode.FAILED, map);
    }

    /**
     * 错误返回，直接返回错误的消息
     * @param msg
     * @return
     */
    public static BaseResponse failureMsg(String msg) {
        return new BaseResponse(ResponseStatusCode.FAILED, msg);
    }

    /**
     * 自定义错误范围，需要传入一个自定义的枚举，可以到[ResponseStatusCode.java[中自定义后再传入
     * @param responseStatus
     * @return
     */
    public static BaseResponse failureCustom(ResponseStatusCode responseStatus) {
        return new BaseResponse(responseStatus);
    }
    public static BaseResponse exception(ResponseStatusCode responseStatus) {
        return new BaseResponse(responseStatus);
    }

    public BaseResponse(ResponseStatusCode responseStatus) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
    }
    public BaseResponse(ResponseStatusCode responseStatus, Object data) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
        this.data = data;
    }
    public BaseResponse(ResponseStatusCode responseStatus, String msg) {
        this.status = responseStatus.status();
        this.msg = msg;
        this.success = responseStatus.success();
    }

}
