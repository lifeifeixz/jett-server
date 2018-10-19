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
package com.jett.dao.jpa;

import com.jett.beans.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author flysLi
 * @ClassName GoodsRepository
 * @Decription TODO
 * @Date 2018/10/15 9:42
 * @Version 1.0
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, String>,JpaSpecificationExecutor {

    Goods findByGoodId(String goodId);

    Page<Goods> findByGoodName(String goodName, Pageable pageable);
}
