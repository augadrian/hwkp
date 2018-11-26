package com.hwkp.dao.Impl;

import com.hwkp.dao.ProductDao;
import com.hwkp.entity.ProductEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public ProductEntity update(ProductEntity productEntity) {
        StringBuffer hq=new StringBuffer("update ProductEntity b set no = no" );
        if(productEntity.getProductId()!=null){
            hq.append(",b.productId= '"+productEntity.getProductId() + "'");
        } if(productEntity.getCover()!=null){
            hq.append(",b.cover= '"+productEntity.getCover() + "'");
        } if(productEntity.getProName()!=null){
            hq.append(",b.proName= '"+productEntity.getProName() + "'");
        } if(productEntity.getProAbstract()!=null){
            hq.append(",b.proAbstract= '"+productEntity.getProAbstract() + "'");
        } if(productEntity.getProIntroduction()!=null){
            hq.append(",b.proIntroduction= '"+productEntity.getProIntroduction() + "'");
        } if(productEntity.getProOriginalPrice()!=null){
            hq.append(",b.proOriginalPrice= '"+productEntity.getProOriginalPrice() + "'");
        } if(productEntity.getExpressFee()!=null){
            hq.append(",b.expressFee= '"+productEntity.getExpressFee() + "'");
        } if(productEntity.getIsActive()!=null){
            hq.append(",b.isActive= '"+productEntity.getIsActive() + "'");
        } if(productEntity.getCreatedUser()!=null){
            hq.append(",b.createdUser= '"+productEntity.getCreatedUser() + "'");
        } if(productEntity.getCreatedTime()!=null){
            hq.append(",b.createdTime= '"+productEntity.getCreatedTime() + "'");
        } if(productEntity.getModifiedUser()!=null){
            hq.append(",b.modifiedUser= '"+productEntity.getModifiedUser() + "'");
        } if(productEntity.getModifiedTime()!=null){
            hq.append(",b.modifiedTime= '"+productEntity.getModifiedTime() + "'");
        }
        String hql = hq + " where b.no =" + productEntity.getNo() + "";

        return this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate() > 0?this.findById(productEntity.getNo()):null;
    }

    @Override
    public void delete(ProductEntity productEntity) {
         super.delete(productEntity);
    }

    @Override
    public ProductEntity findById(Integer id) {
        return (ProductEntity) super.findById(ProductEntity.class,id);
    }

    @Override
    public List<ProductEntity> findAll(Integer pageNo, Integer pageSize) {
        String sql=new String("select p from ProductEntity p where 1=1");
        List<ProductEntity> productEntityList=new ArrayList<ProductEntity>();
        if(pageNo!=null) {
             productEntityList =this.sessionFactory.getCurrentSession().createQuery(sql).setFirstResult((pageNo - 1) * pageSize)
                    .setMaxResults(pageSize).list();;

        }else {
            productEntityList = this.sessionFactory.getCurrentSession().createQuery(sql).list();
        }
        return productEntityList!=null&&productEntityList.size()>0?productEntityList:null;
    }
}
