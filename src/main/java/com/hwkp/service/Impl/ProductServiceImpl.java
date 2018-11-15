package com.hwkp.service.Impl;

import com.hwkp.dao.ProductDao;
import com.hwkp.entity.ProductEntity;
import com.hwkp.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void save(ProductEntity productEntity) {
        productDao.save(productEntity);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        return   productDao.update(productEntity);
    }

    @Override
    public void delete(ProductEntity productEntity) {
           productDao.delete(productEntity);
    }

    @Override
    public ProductEntity findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public List<ProductEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
