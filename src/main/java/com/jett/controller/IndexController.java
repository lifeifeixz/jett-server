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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author flysLi
 * @ClassName IndexController
 * @Decription TODO
 * @Date 2018/10/10 15:09
 * @Version 1.0
 */
@Controller
public class IndexController {


    @Value("${spring.datasource.url}")
    private String  url;
    @RequestMapping("/index")
    public String index() {
        return "hello";
    }

    @GetMapping("/data")
    @ResponseBody
    public Object data() {
        System.out.println(url);
        return url;
    }
}
