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
package com.jett.exception;

import com.jett.beans.enums.ResultEnum;

/**
 * @author flysLi
 * @ClassName BaseException
 * @Decription TODO
 * @Date 2018/10/16 11:08
 * @Version 1.0
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException() {

    }

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
