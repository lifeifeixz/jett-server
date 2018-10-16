/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.jett.beans.enums;

/**
 * @author flysLi
 * @ClassName ResultEnum
 * @Decription TODO
 * @Date 2018/10/16 11:32
 * @Version 1.0
 */
public enum ResultEnum {
    /**
     * 成功. ErrorCode : 0
     */
    SUCCESS(0, "成功"),
    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException(01, "未知异常"),
    /**
     * 系统异常. ErrorCode : 02
     */
    SystemException(02, "系统异常"),
    /**
     * 业务错误. ErrorCode : 03
     */
    MyException(03, "业务错误"),
    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException(04, "提示级错误"),
    /**
     * 业务错误：身份验证失败
     */
    AuthenException(04, "提示级错误"),
    /**
     * 数据库操作异常. ErrorCode : 020001
     */
    DBException(020001, "数据库操作异常"),
    /**
     * 参数验证错误. ErrorCode : 040001
     */
    ParamException(040001, "参数验证错误");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
