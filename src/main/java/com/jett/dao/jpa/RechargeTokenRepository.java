package com.jett.dao.jpa;

import com.jett.beans.RechargeToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author flysLi
 * @date 2018/10/15
 */
public interface RechargeTokenRepository extends JpaRepository<RechargeToken, Integer>, JpaSpecificationExecutor {

    RechargeToken findByToken(String token);

}
