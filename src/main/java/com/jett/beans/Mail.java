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

/**
 * @author flysLi
 * @ClassName Mail
 * @Decription TODO
 * @Date 2018/10/11 10:56
 * @Version 1.0
 */
public class Mail {
    private int id;
    private int state;
    private String fromZone;
    private String fromName;
    private String toZone;
    private String toName;
    private String title;
    private String type;
    private int createTime;
    private int delTime;
    private int accessOry;
    private int itemGot;
    private String text;
    private int sendMoneyNumA;
    private int sendMoneyNumB;
    private String toId;
    private int fromId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFromZone() {
        return fromZone;
    }

    public void setFromZone(String fromZone) {
        this.fromZone = fromZone;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToZone() {
        return toZone;
    }

    public void setToZone(String toZone) {
        this.toZone = toZone;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getDelTime() {
        return delTime;
    }

    public void setDelTime(int delTime) {
        this.delTime = delTime;
    }

    public int getAccessOry() {
        return accessOry;
    }

    public void setAccessOry(int accessOry) {
        this.accessOry = accessOry;
    }

    public int getItemGot() {
        return itemGot;
    }

    public void setItemGot(int itemGot) {
        this.itemGot = itemGot;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSendMoneyNumA() {
        return sendMoneyNumA;
    }

    public void setSendMoneyNumA(int sendMoneyNumA) {
        this.sendMoneyNumA = sendMoneyNumA;
    }

    public int getSendMoneyNumB() {
        return sendMoneyNumB;
    }

    public void setSendMoneyNumB(int sendMoneyNumB) {
        this.sendMoneyNumB = sendMoneyNumB;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }
}
