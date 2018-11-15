package com.hwkp.service.Impl;

import com.hwkp.dao.OrderDao;
import com.hwkp.entity.OrderEntity;
import com.hwkp.service.OrderService;
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
public class OrderServiceImpl implements OrderService  {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(OrderEntity orderEntity) {
        orderDao.save(orderEntity);
    }

    @Override
    public void update(OrderEntity orderEntity) {
        orderDao.update(orderEntity);
    }

    @Override
    public void delete(OrderEntity orderEntity) {
       orderDao.delete(orderEntity);
    }

    @Override
    public OrderEntity findById(OrderEntity orderEntity) {
        return null;
    }

    @Override
    public List<OrderEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
