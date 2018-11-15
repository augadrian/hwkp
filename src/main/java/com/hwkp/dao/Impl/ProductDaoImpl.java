package com.hwkp.dao.Impl;

import com.hwkp.dao.ProductDao;
import com.hwkp.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Repository
public class ProductDaoImpl  extends BaseDaoImpl<ProductEntity> implements ProductDao {
    @Override
    public void save(ProductEntity productEntity) {
        super.save(productEntity);
    }

    @Override
    public void update(ProductEntity productEntity) {
        StringBuffer hq=new StringBuffer("update b_product b set no=no" );
        if(productEntity.getProductId()!=null){
            hq.append(",b.product_id="+productEntity.getProductId());
        } if(productEntity.getCover()!=null){
            hq.append(",b.cover="+productEntity.getCover());
        } if(productEntity.getProName()!=null){
            hq.append(",b.pro_name="+productEntity.getProName());
        } if(productEntity.getProAbstract()!=null){
            hq.append(",b.pro_abstract="+productEntity.getProAbstract());
        } if(productEntity.getProIntroduction()!=null){
            hq.append(",b.pro_introduction="+productEntity.getProIntroduction());
        } if(productEntity.getProOriginal_price()!=0){
            hq.append(",b.pro_original_price="+productEntity.getProOriginal_price());
        } if(productEntity.getExpressFee()!=0){
            hq.append(",b.express_fee="+productEntity.getExpressFee());
        } if(productEntity.getIsActive()!=null){
            hq.append(",b.is_active="+productEntity.getIsActive());
        } if(productEntity.getCreatedUser()!=null){
            hq.append(",b.created_user="+productEntity.getCreatedUser());
        } if(productEntity.getCreatedTime()!=null){
            hq.append(",b.created_time="+productEntity.getCreatedTime());
        } if(productEntity.getModifiedUser()!=null){
            hq.append(",b.modified_user="+productEntity.getModifiedUser());
        } if(productEntity.getModifiedTime()!=null){
            hq.append(",b.modified_time="+productEntity.getModifiedTime());
        }
    }

    @Override
    public void delete(ProductEntity productEntity) {
         super.delete(productEntity);
    }

    @Override
    public ProductEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<ProductEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
