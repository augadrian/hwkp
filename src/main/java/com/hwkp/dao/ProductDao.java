package com.hwkp.dao;

import com.hwkp.entity.OrderEntity;
import com.hwkp.entity.ProductEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
public interface ProductDao extends BaseDao<ProductEntity> {

    ProductEntity findById(Integer id);
    List<ProductEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
