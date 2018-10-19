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
import com.jett.beans.req.RechargeTokenPageReq;
import com.jett.dao.jpa.RechargeTokenRepository;
import com.jett.exception.BaseException;
import com.jett.service.RechargeService;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private RechargeTokenRepository rechargeTokenRepository;

    @PostMapping("/recharge")
    @ResponseBody
    public Object recharge(@RequestBody(required = false) @Valid RechargeReq req) {
        return rechargeService.recharge(req);
    }

    @RequestMapping("/getToken")
    @ResponseBody
    public RechargeToken generateRechargeToken(@ApiParam(value = "账户") @RequestParam() String user,
                                               @ApiParam(value = "密码") @RequestParam(required = true) String pwd,
                                               @ApiParam(value = "可充值次数") @RequestParam(required = false) Integer count) {
        if (user.equals("admin") && pwd.equals("111111")) {
            return rechargeService.generateToken(count);
        } else {
            throw new BaseException(ResultEnum.AuthenException);
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page<RechargeToken> page(@RequestBody(required = false) @Valid RechargeTokenPageReq req) {
        //Specification 查询
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isNullOrEmpty(req.getToken())) {
                    predicates.add(criteriaBuilder.like(root.get("token"), "%" + req.getToken() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return rechargeTokenRepository.findAll(specification, new PageRequest(req.getPage(), req.getSize(), Sort.Direction.DESC,"createTime"));
    }

    @RequestMapping("/getByToken")
    @ResponseBody
    public RechargeToken getByToken(@ApiParam(value = "账户") @RequestParam() String token) {
        return rechargeTokenRepository.findByToken(token);
    }

    @RequestMapping("/del")
    @ResponseBody
    public void del(@ApiParam(value = "id") @RequestParam() int id) {
        rechargeTokenRepository.deleteById(id);
    }
}
