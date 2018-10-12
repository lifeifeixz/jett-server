package com.jett.dao;

import com.jett.beans.Mail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author flysLi
 * @date 2018/10/11
 */
@Mapper
public interface MailMapper {

    int add(Mail mail);

    /**
     *
     * @param name
     * @return
     */
    int findCharIdByName(@Param("name") String name);

    String findUserIdByName(String name);
}
