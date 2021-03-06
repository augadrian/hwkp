package com.hwkp.dao;

import com.hwkp.entity.ProductEntity;
import com.hwkp.entity.SysAdminAccountEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
public interface SysAdminAccountDao  extends BaseDao<SysAdminAccountEntity> {

    SysAdminAccountEntity findByUserId(String userId);
    SysAdminAccountEntity findByno(Integer no);
    List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize);
    SysAdminAccountEntity verifyAdmin(String account,String  password);
}
