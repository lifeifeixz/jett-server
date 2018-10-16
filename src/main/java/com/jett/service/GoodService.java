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

import com.jett.beans.Goods;
import com.jett.dao.jpa.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author flysLi
 * @ClassName GoodService
 * @Decription TODO
 * @Date 2018/10/10 15:18
 * @Version 1.0
 */
@Service
public class GoodService {
    @Autowired
    private GoodsRepository goodsRepository;

    public Page<Goods> searchGoodsByGoods(Goods goods) {
        List<Predicate> predicates = new LinkedList<>();
        CriteriaBuilder criteriaBuilder;
        if (!StringUtils.isEmpty(goods.getGoodName())) {
        }
        goodsRepository.findAll();
        return null;
    }
}
