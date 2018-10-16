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

import com.jett.beans.RechargeToken;
import com.jett.beans.enums.ResultEnum;
import com.jett.beans.req.RechargeReq;
import com.jett.exception.BaseException;
import com.jett.service.RechargeService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Object recharge(@RequestBody(required = false) @Valid RechargeReq req) {
        return rechargeService.recharge(req);
    }

    @RequestMapping("/getToken")
    @ResponseBody
    public RechargeToken generateRechargeToken(@ApiParam(value = "账户") @RequestParam() String user,
                                               @ApiParam(value = "密码") @RequestParam(required = true) String pwd) {
        if (user.equals("admin") && pwd.equals("111111")) {
            return rechargeService.generateToken();
        } else {
            throw new BaseException(ResultEnum.AuthenException);
        }
    }
}
