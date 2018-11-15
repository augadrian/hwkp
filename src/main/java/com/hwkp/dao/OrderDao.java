package com.hwkp.dao;

import com.hwkp.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
public interface OrderDao  extends BaseDao<OrderEntity>{

    OrderEntity findById(Integer id);
    List<OrderEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
