package com.hwkp.service;

import com.hwkp.entity.OrderEntity;

import java.util.List;
import java.util.Map;

public interface OrderService   {

    void save(OrderEntity orderEntity);
    void update(OrderEntity orderEntity);
    void delete(OrderEntity orderEntity);
    OrderEntity findById(OrderEntity orderEntity);
    List<OrderEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
