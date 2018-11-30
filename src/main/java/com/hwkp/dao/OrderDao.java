package com.hwkp.dao;

import com.hwkp.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
public interface OrderDao  extends BaseDao<OrderEntity>{
   OrderEntity findById(Integer id);
    OrderEntity findByOrderId(String orderId);
    List<OrderEntity> findAll(Integer pageNo, Integer pageSize);
    List<OrderEntity> findByTime(Integer pageNo, Integer pageSize,Map<String, String> parms);
    OrderEntity editExpress(String orderId,String expressNum);
}
