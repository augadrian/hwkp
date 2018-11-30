package com.hwkp.dao.Impl;

import com.hwkp.dao.OrderDao;
import com.hwkp.entity.OrderEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    public OrderEntity findByOrderId(String orderId) {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(OrderEntity.class);
        criteria.add(Restrictions.eq("orderId",orderId));
        return criteria!=null?(OrderEntity) criteria.list().get(0):null;
    }

    @Override
    public List<OrderEntity> findAll(Integer pageNo, Integer pageSize) {
        String sql=new String("select p from OrderEntity p where 1=1");
        List<OrderEntity> orderEntityList=new ArrayList<OrderEntity>();
        if(pageNo!=null) {
            orderEntityList =this.sessionFactory.getCurrentSession().createQuery(sql).setFirstResult((pageNo - 1) * pageSize)
                    .setMaxResults(pageSize).list();

        }else {
            orderEntityList = this.sessionFactory.getCurrentSession().createQuery(sql).list();
        }
        return orderEntityList!=null&&orderEntityList.size()>0?orderEntityList:null;
    }

    @Override
    public List<OrderEntity> findByTime(Integer pageNo, Integer pageSize, Map<String, String> params) {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(OrderEntity.class);
        if(params.containsKey("startTime") && !StringUtils.isEmpty(params.get("startTime"))&&!(params.get("startTime")+"").equals("0")){
            criteria.add(Restrictions.ge("paidTime",params.get("startTime")));
        }if(params.containsKey("endTime") && !StringUtils.isEmpty(params.get("endTime"))&&!(params.get("endTime")+"").equals("0")){
            criteria.add(Restrictions.le("paidTime",params.get("endTime")));
        }
        if(params.containsKey("isSend") && !StringUtils.isEmpty(params.get("isSend"))&&!(params.get("isSend")+"").equals("0")){
            criteria.add(Restrictions.eq("isSend",params.get("isSend")));
        }
        if (pageNo != 0 && pageSize != 0) {
            criteria.setFirstResult((pageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize);
        }
        return criteria.list();
    }

    @Override
    public OrderEntity editExpress(String orderId,String expressNum) {
       int n=this.sessionFactory.getCurrentSession().createQuery("update  OrderEntity o  set o.expressNum =? where o.orderId=?").setParameter(0,expressNum).setParameter(1,orderId).executeUpdate();
        return n>0?this.findByOrderId(orderId):null;

    }

}
