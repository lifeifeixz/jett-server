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
package com.jett.controller;

import com.jett.beans.req.RechargeReq;
import com.jett.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author flysLi
 * @ClassName RechargeController
 * @Decription TODO
 * @Date 2018/10/11 13:28
 * @Version 1.0
 */
@RequestMapping(value = "/api/v1")
@Controller
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping("/recharge")
    @ResponseBody
    public Object recharge(@RequestBody(required = false) @Valid RechargeReq req){
        return rechargeService.recharge(req);
    }
}
