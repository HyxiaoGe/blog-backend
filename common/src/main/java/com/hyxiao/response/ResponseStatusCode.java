package com.hyxiao.response;

import lombok.AllArgsConstructor;

/**
 * 响应结果枚举，用于提供给GraceJSONResult返回给前端的
 * 本枚举类中包含了很多的不同的状态码供使用，可以自定义
 * 便于更优雅的对状态码进行管理，一目了然
 */
@AllArgsConstructor
public enum ResponseStatusCode {

    SUCCESS(200, true, "操作成功！"), FAILED(500, false, "操作失败！"),

    // 50x
    UN_LOGIN(501, false, "请登录后再继续操作！"), TICKET_INVALID(502, false, "会话失效，请重新登录！"), HR_TICKET_INVALID(5021, false, "手机端会话失效，请重新登录！"), NO_AUTH(503, false, "您的权限不足，无法继续操作！"), MOBILE_ERROR(504, false, "短信发送失败，请稍后重试！"), SMS_NEED_WAIT_ERROR(505, false, "短信发送太快啦~请稍后再试！"), SMS_CODE_ERROR(506, false, "验证码过期或不匹配，请稍后再试！"), USER_FROZEN(507, false, "用户已被冻结，请联系管理员！"), USER_UPDATE_ERROR(508, false, "用户信息更新失败，请联系管理员！"), USER_INACTIVE_ERROR(509, false, "请前往[账号设置]修改信息激活后再进行后续操作！"), USER_INFO_UPDATED_ERROR(5091, false, "用户信息修改失败！"), USER_INFO_UPDATED_NICKNAME_EXIST_ERROR(5092, false, "昵称已经存在！"), USER_INFO_UPDATED_IMOOCNUM_EXIST_ERROR(5092, false, "慕课号已经存在！"), USER_INFO_CANT_UPDATED_IMOOCNUM_ERROR(5092, false, "慕课号无法修改！"), FILE_UPLOAD_NULL_ERROR(510, false, "文件不能为空，请选择一个文件再上传！"), FILE_UPLOAD_FAILD(511, false, "文件上传失败！"), FILE_FORMATTER_FAILD(512, false, "文件图片格式不支持！"), FILE_MAX_SIZE_500KB_ERROR(5131, false, "仅支持500kb大小以下的文件上传！"), FILE_MAX_SIZE_2MB_ERROR(5132, false, "仅支持2MB大小以下的文件上传！"), FILE_MAX_SIZE_8MB_ERROR(5132, false, "体验版仅支持8MB以下的文件上传！"), FILE_MAX_SIZE_100MB_ERROR(5132, false, "仅支持100MB大小以下的文件上传！"), FILE_NOT_EXIST_ERROR(514, false, "你所查看的文件不存在！"), USER_STATUS_ERROR(515, false, "用户状态参数出错！"), USER_NOT_EXIST_ERROR(516, false, "用户不存在！"), USER_PARAMS_ERROR(517, false, "用户请求参数出错！"), USER_REGISTER_ERROR(518, false, "用户注册失败，请重试！"),

    // 系统错误，未预期的错误 555
    SYSTEM_ERROR(555, false, "系统繁忙，请稍后再试！"), SYSTEM_OPERATION_ERROR(556, false, "操作失败，请重试或联系管理员"), SYSTEM_RESPONSE_NO_INFO(557, false, ""), SYSTEM_ERROR_GLOBAL(558, false, "全局降级：系统繁忙，请稍后再试！"), SYSTEM_ERROR_FEIGN(559, false, "客户端Feign降级：系统繁忙，请稍后再试！"), SYSTEM_ERROR_ZUUL(560, false, "请求系统过于繁忙，请稍后再试！"), SYSTEM_PARAMS_SETTINGS_ERROR(5611, false, "参数设置不规范！"), ZOOKEEPER_BAD_VERSION_ERROR(5612, false, "数据过时，请刷新页面重试！"), SYSTEM_ERROR_BLACK_IP(5621, false, "请求过于频繁，请稍后重试！"), SYSTEM_SMS_FALLBACK_ERROR(5587, false, "短信业务繁忙，请稍后再试！"), SYS_DATA_ERROR(5588, false, "系统参数为空，请检查系统参数表sys_params！"), SYSTEM_ERROR_NOT_BLANK(5599, false, "系统错误，参数不能为空！"),

    JWT_SIGNATURE_ERROR(5555, false, "用户校验失败，请重新登录！"), JWT_EXPIRE_ERROR(5556, false, "登录有效期已过，请重新登录！"),

    SENTINEL_BLOCK_FLOW_LIMIT_ERROR(5801, false, "系统访问繁忙，请稍后再试！");

    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    public Integer status() {
        return status;
    }

    public Boolean success() {
        return success;
    }

    public String msg() {
        return msg;
    }
}
