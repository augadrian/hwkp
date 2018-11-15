package com.hwkp.service;

import com.hwkp.entity.AdvEntity;

import java.util.List;
import java.util.Map;

public interface AdvService    {

    void save(AdvEntity advEntity);
    void update(AdvEntity advEntity);
    void delete(AdvEntity advEntity);
    AdvEntity findById(AdvEntity advEntity);
    List<AdvEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
