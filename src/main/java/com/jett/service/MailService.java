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

import com.jett.beans.Mail;
import com.jett.dao.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author flysLi
 * @ClassName MailService
 * @Decription TODO
 * @Date 2018/10/11 14:17
 * @Version 1.0
 */
@Service
public class MailService {

    @Autowired
    private MailMapper mailMapper;

    public int add(Mail mail) {
        return mailMapper.add(mail);
    }
}
