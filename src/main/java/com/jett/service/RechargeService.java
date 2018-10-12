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
package com.jett.service;

import com.jett.beans.Gift;
import com.jett.beans.common.Result;
import com.jett.beans.req.RechargeReq;
import com.jett.business.MySQLUtil;
import com.jett.dao.GiftMapper;
import com.jett.dao.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flysLi
 * @ClassName RechargeService
 * @Decription TODO
 * @Date 2018/10/11 13:34
 * @Version 1.0
 */
@Service
public class RechargeService {

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private GiftMapper giftMapper;

    @Transactional
    public Result recharge(RechargeReq req) {
        Result result = new Result();
        int charId = MySQLUtil.executeCharId(req.getName());
        Gift gift = new Gift();
        gift.setCharId(charId);
        gift.setName(req.getName());
        gift.setItemId1(req.getItemId1());
        gift.setItemNum1(req.getItemNum1());
        int giftCount = giftMapper.add(gift);
        int commandCount = MySQLUtil.cmmand();
        result.setStatus(Result.SUCCESS);
        Map<String, Object> content = new HashMap<>(2);
        content.put("gift", giftCount);
        content.put("command", commandCount);
        result.setT(content);
        return result;
    }
}
