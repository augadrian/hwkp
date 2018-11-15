package com.hwkp.service;


import com.hwkp.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService  {

    void save(ProductEntity productEntity);
    ProductEntity update(ProductEntity productEntity);
    void delete(ProductEntity productEntity);
    ProductEntity findById(Integer id);
    List<ProductEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
