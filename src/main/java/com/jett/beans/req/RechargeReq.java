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
package com.jett.beans.req;

import javax.validation.constraints.NotNull;

/**
 * @author flysLi
 * @ClassName RechargeReq
 * @Decription TODO
 * @Date 2018/10/11 13:30
 * @Version 1.0
 */
public class RechargeReq {

    @NotNull(message = "角色名不可为空")
    private String name;

    @NotNull(message = "礼物ID不可为空")
    private int itemId1;

    @NotNull(message = "礼物数量不可为空")
    private int itemNum1;

    @NotNull(message = "授权码不可为空")
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemId1() {
        return itemId1;
    }

    public void setItemId1(int itemId1) {
        this.itemId1 = itemId1;
    }

    public int getItemNum1() {
        return itemNum1;
    }

    public void setItemNum1(int itemNum1) {
        this.itemNum1 = itemNum1;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
