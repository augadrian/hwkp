package com.hwkp.service.Impl;

import com.hwkp.dao.SysAdminAccountDao;
import com.hwkp.entity.SysAdminAccountEntity;
import com.hwkp.service.SysAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Service
@Transactional(readOnly = false)
public class SysAdminAccountServiceImpl implements SysAdminAccountService {

     @Autowired
     private SysAdminAccountDao sysAdminAccountDao;

    @Override
    public void save(SysAdminAccountEntity sysAdminAccountEntity) {
           sysAdminAccountDao.save(sysAdminAccountEntity);
    }

    @Override
    public void update(SysAdminAccountEntity sysAdminAccountEntity) {
        sysAdminAccountDao.update(sysAdminAccountEntity);
    }

    @Override
    public void delete(SysAdminAccountEntity sysAdminAccountEntity) {
       sysAdminAccountDao.delete(sysAdminAccountEntity);
    }

    @Override
    public SysAdminAccountEntity findById(SysAdminAccountEntity sysAdminAccountEntity) {
        return null;
    }

    @Override
    public List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
