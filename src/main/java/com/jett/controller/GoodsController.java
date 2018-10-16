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

import com.jett.beans.Goods;
import com.jett.beans.common.Result;
import com.jett.dao.jpa.GoodsRepository;
import com.jett.exception.BaseException;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author flysLi
 * @ClassName GoodsController
 * @Decription TODO
 * @Date 2018/10/15 10:15
 * @Version 1.0
 */
@RequestMapping(value = "/api/v1/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @ApiOperation("搜索物品")
    @RequestMapping(value = "/goods", method = {RequestMethod.POST, RequestMethod.GET})
    public Page<Goods> findByGoodName(@ApiParam(value = "物品名称") @RequestParam(required = false) String goodName,
                                      @ApiParam(value = "第几页") @RequestParam(required = false) int page,
                                      @ApiParam(value = "每页显示几条") @RequestParam(required = false) int size) {

        //Specification 查询
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isNullOrEmpty(goodName)) {
                    predicates.add(criteriaBuilder.like(root.get("goodName"), "%" + goodName + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return goodsRepository.findAll(specification, new PageRequest(page, size));
    }

    @ApiOperation("添加/更新物品")
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public Goods addGoods(@ApiParam(value = "物品名称") @RequestParam(required = false) String goodName,
                          @ApiParam(value = "物品ID") @RequestParam(required = false) String goodId) {

        Goods goods = new Goods(goodId, goodName);
        return goodsRepository.save(goods);
    }

    @ApiOperation("删除物品")
    @GetMapping("/del")
    public void del(@ApiParam(value = "物品ID") @RequestParam(required = false) String goodId) {
        goodsRepository.deleteById(goodId);
    }


}
