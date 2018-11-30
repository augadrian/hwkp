package com.hwkp.service;

import com.hwkp.entity.OrderEntity;

import java.util.List;
import java.util.Map;

public interface OrderService   {

    void save(OrderEntity orderEntity);
    OrderEntity update(OrderEntity orderEntity);
    void delete(OrderEntity orderEntity);
    OrderEntity findByOrderId(String orderId);
    OrderEntity findById(Integer id);
    List<OrderEntity> findAll(Integer pageNo, Integer pageSize);
    OrderEntity editExpress(String orderId,String expressNum);
}
