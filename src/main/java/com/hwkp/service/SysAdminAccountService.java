package com.hwkp.service;

import com.hwkp.entity.SysAdminAccountEntity;

import java.util.List;
import java.util.Map;

public interface SysAdminAccountService   {

    void save(SysAdminAccountEntity sysAdminAccountEntity);
    SysAdminAccountEntity update(SysAdminAccountEntity sysAdminAccountEntity);
    void delete(SysAdminAccountEntity sysAdminAccountEntity);
    SysAdminAccountEntity findByUserId(String userId);
    SysAdminAccountEntity findByno(Integer no);
    List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize);
    SysAdminAccountEntity verifyAdmin(String account,String  password);

}
