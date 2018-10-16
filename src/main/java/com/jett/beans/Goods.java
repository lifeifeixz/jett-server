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
package com.jett.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author flysLi
 * @ClassName Goods
 * @Decription TODO
 * @Date 2018/10/10 16:57
 * @Version 1.0
 */
@Entity
@Table(name = "goods")
public class Goods implements Serializable{

    @Id
    private String goodId;
    private String goodName;

    public Goods(String goodId, String goodName) {
        this.goodId = goodId;
        this.goodName = goodName;
    }

    public Goods() {
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
