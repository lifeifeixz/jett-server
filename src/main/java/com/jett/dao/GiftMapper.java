package com.jett.dao;

import com.jett.beans.Gift;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author flysLi
 * @date 2018/10/11
 */
@Mapper
public interface GiftMapper {
    int add(Gift gift);

    String findCharIdByName(String name);
}
