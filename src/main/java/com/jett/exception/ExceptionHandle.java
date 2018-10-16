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

import com.jett.beans.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author flysLi
 * @ClassName ExceptionHandle
 * @Decription TODO
 * @Date 2018/10/16 11:03
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return new Result(baseException.getCode(), Result.FAIL, e.getMessage());
        }
        return new Result(3, Result.FAIL, "系统异常", e.getLocalizedMessage());
    }

}
