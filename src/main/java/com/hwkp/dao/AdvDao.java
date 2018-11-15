package com.hwkp.dao;

import com.hwkp.entity.AdvEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
public interface AdvDao extends BaseDao<AdvEntity>{


    AdvEntity findById(Integer id);

    List<AdvEntity> findAll(Integer pageNo,Integer pageSize,Map<String,Object> params);

}
