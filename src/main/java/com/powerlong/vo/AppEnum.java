package com.powerlong.vo;


import com.powerlong.common.ExceptionEnum;

/**
 * Created by Angus on 2015/5/28.
 */
public enum AppEnum implements ExceptionEnum {

    APP_SCAN_NUM("APP0001", "绑定二维码失败", ""),
    APP_GET_INVENTORY("APP0002", "获取水单详情失败", "");

    /**
     * 异常代码
     */
    private String code;

    /**
     * 后台异常信息
     */
    private String bakMessage;

    /**
     * 友好异常信息
     */
    String frontMessage;
    /**
     *
     * 创建一个新的实例 UserExceptionEnumImpl.
     *
     * @param code
     * @param bakMessage
     * @param frontMessage
     */
    private  AppEnum(String code, String bakMessage, String frontMessage){
        this.code = code;
        this.bakMessage = bakMessage;
        this.frontMessage = frontMessage;
    }
    /**
     * 未定义错误代码的错误信息
     */
    private static final String COMMON_ERROR_MESSAGE = "抱歉！系统繁忙，请稍后重试。";

    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return bakMessage;
    }
    public static String getMessage(String code) {
        for(AppEnum errorMessageEnum :AppEnum.values()){
            if(errorMessageEnum.getCode().equalsIgnoreCase(code)){
                return errorMessageEnum.frontMessage;
            }
        }
        return COMMON_ERROR_MESSAGE;
    }
}
