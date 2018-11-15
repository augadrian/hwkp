package com.hwkp.service.Impl;

import com.hwkp.dao.AdvDao;
import com.hwkp.entity.AdvEntity;
import com.hwkp.service.AdvService;
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
public class AdvServiceImpl implements AdvService {


    @Autowired
    private AdvDao advDao;

    @Override
    public void save(AdvEntity advEntity) {
           advDao.save(advEntity);
    }
    @Override
    public void update(AdvEntity advEntity) {
          advDao.update(advEntity);
    }

    @Override
    public void delete(AdvEntity advEntity) {
          advDao.delete(advEntity);
    }

    @Override
    public AdvEntity findById(AdvEntity advEntity) {
        return null;
    }

    @Override
    public List<AdvEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
