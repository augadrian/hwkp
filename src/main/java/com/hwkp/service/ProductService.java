package com.hwkp.service;


import com.hwkp.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService  {

    void save(ProductEntity productEntity);
    void update(ProductEntity productEntity);
    void delete(ProductEntity productEntity);
    ProductEntity findById(ProductEntity productEntity);
    List<ProductEntity> findAll(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
