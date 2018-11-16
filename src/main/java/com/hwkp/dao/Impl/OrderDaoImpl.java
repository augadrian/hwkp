package com.hwkp.dao.Impl;

import com.hwkp.dao.OrderDao;
import com.hwkp.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl<OrderEntity> implements OrderDao {

    @Override
    public void save(OrderEntity orderEntity) {
        super.save(orderEntity);
    }

    @Override
    public OrderEntity update(OrderEntity orderEntity) {
        StringBuffer hq=new StringBuffer("update b_order b set id=id");
        if(orderEntity.getOrderId()!=null){
            hq.append(",b.order_id="+orderEntity.getOrderId());
        }if(orderEntity.getTransactionId()!=null){
            hq.append(",b.transaction_id="+orderEntity.getTransactionId());
        }if(orderEntity.getRoundId()!=null){
            hq.append(",b.round_id="+orderEntity.getRoundId());
        }if(orderEntity.getProductId()!=null){
            hq.append(",b.product_id="+orderEntity.getProductId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.zip_code="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.province_name="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.city_name="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.county_name="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.detail_info="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.tel_number="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.user_name="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.wx_openid="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.nonce_str="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.is_paid="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.paid_time="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.express_num="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.is_send="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.send_time="+orderEntity.getOrderId());
        }if(orderEntity.getOrderId()!=null){
            hq.append(",b.is_active="+orderEntity.getOrderId());
        }
        String hql = hq + " where a.id =" + orderEntity.getId() + "";

        return this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate()> 0?this.findById(orderEntity.getId()):null;
    }

    @Override
    public void delete(OrderEntity orderEntity) {

        super.delete(orderEntity);
    }

    @Override
    public OrderEntity findById(Integer id) {
        return (OrderEntity) super.findById(OrderEntity.class,id);
    }

    @Override
    public List<OrderEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
