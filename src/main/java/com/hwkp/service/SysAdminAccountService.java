package com.hwkp.service;

import com.hwkp.entity.SysAdminAccountEntity;

import java.util.List;
import java.util.Map;

public interface SysAdminAccountService   {

    void save(SysAdminAccountEntity sysAdminAccountEntity);
    SysAdminAccountEntity update(SysAdminAccountEntity sysAdminAccountEntity);
    void delete(SysAdminAccountEntity sysAdminAccountEntity);
    SysAdminAccountEntity findById(Integer id);
    List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
    SysAdminAccountEntity verifyAdmin(SysAdminAccountEntity sysAdminAccountEntity);

}
