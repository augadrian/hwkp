package com.hwkp.service;

import com.hwkp.entity.AdvEntity;

import java.util.List;
import java.util.Map;

public interface AdvService    {

    void save(AdvEntity advEntity);
    AdvEntity update(AdvEntity advEntity);
    void delete(AdvEntity advEntity);
    AdvEntity findById(Integer id);
    List<AdvEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
