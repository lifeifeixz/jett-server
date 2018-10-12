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
import com.jett.dao.GiftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author flysLi
 * @ClassName GiftService
 * @Decription TODO
 * @Date 2018/10/11 14:03
 * @Version 1.0
 */
@Service
public class GiftService {

    @Autowired
    private GiftMapper giftMapper;

    public Result addGift(Gift gift) {
        Result result = new Result();
        int count = giftMapper.add(gift);
        return result;
    }
}
