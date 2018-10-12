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
package com.jett.beans.common;

/**
 * @author flysLi
 * @ClassName Result
 * @Decription TODO
 * @Date 2018/10/11 13:35
 * @Version 1.0
 */
public class Result<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    private int code;
    private String status;
    private String message;
    private T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getT() {
        return content;
    }

    public void setT(T content) {
        this.content = content;
    }

    public Result() {
    }

    public Result(String status) {
        this.status = status;
    }

    public Result(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public Result(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Result(int code, String status, String message, T content) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.content = content;
    }
}
