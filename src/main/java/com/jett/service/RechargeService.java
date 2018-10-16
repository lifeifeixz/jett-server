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
import com.jett.beans.RechargeToken;
import com.jett.beans.common.Result;
import com.jett.beans.req.RechargeReq;
import com.jett.business.MySQLUtil;
import com.jett.dao.GiftMapper;
import com.jett.dao.MailMapper;
import com.jett.dao.jpa.RechargeTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    @Autowired
    private RechargeTokenRepository rechargeTokenRepository;

    @Transactional
    public Result recharge(RechargeReq req) {
        Result result = new Result();
        //验证token是否有效
        RechargeToken token = rechargeTokenRepository.findByToken(req.getToken());
        if (token != null) {
            if (token.getStockCount() > 0) {
                int charId = MySQLUtil.executeCharId(req.getName());
                Gift gift = new Gift();
                gift.setCharId(charId);
                gift.setName(req.getName());
                gift.setItemId1(req.getItemId1());
                gift.setItemNum1(req.getItemNum1());
                int giftCount = giftMapper.add(gift);
                int commandCount = MySQLUtil.cmmand();

                token.setStockCount(token.getStockCount() - 1);
                rechargeTokenRepository.save(token);

                result.setStatus(Result.SUCCESS);
                Map<String, Object> content = new HashMap<>(2);
                content.put("gift", giftCount);
                content.put("command", commandCount);
                result.setContent(content);
            } else {
                result.setStatus(Result.FAIL);
                result.setContent("授权码已过期,请联系管理员重新申请");
            }
        } else {
            result.setStatus(Result.FAIL);
            result.setContent("授权码不正确,请联系管理员申请");
        }
        return result;
    }

    public RechargeToken generateToken() {
        String token = UUID.randomUUID().toString();
        RechargeToken rechargeToken = new RechargeToken();
        rechargeToken.setCreateTime(System.currentTimeMillis() / 1000);
        rechargeToken.setToken(token);
        rechargeToken.setStockCount(100);
        rechargeToken = rechargeTokenRepository.save(rechargeToken);
        return rechargeToken;
    }
}
