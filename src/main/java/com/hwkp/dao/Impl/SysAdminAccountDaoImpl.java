package com.hwkp.dao.Impl;

import com.hwkp.dao.SysAdminAccountDao;
import com.hwkp.entity.SysAdminAccountEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Repository
public class SysAdminAccountDaoImpl  extends BaseDaoImpl<SysAdminAccountEntity> implements SysAdminAccountDao {
    @Override
    public void save(SysAdminAccountEntity sysAdminAccountEntity) {
        super.save(sysAdminAccountEntity);
    }

    @Override
    public SysAdminAccountEntity update(SysAdminAccountEntity sysAdminAccountEntity) {
        StringBuffer hq=new StringBuffer("update SysAdminAccountEntity s set no = no");
        if(sysAdminAccountEntity.getUserId()!=null){
            hq.append(",s.userId= '"+sysAdminAccountEntity.getUserId()+ "'");
        }if(sysAdminAccountEntity.getWxOpenid()!=null){
            hq.append(",s.wxOpenid= '"+sysAdminAccountEntity.getWxOpenid()+ "'");
        }if(sysAdminAccountEntity.getAccount()!=null){
            hq.append(",s.account= '"+sysAdminAccountEntity.getAccount()+ "'");
        }if(sysAdminAccountEntity.getPassword()!=null){
            hq.append(",s.password= '"+sysAdminAccountEntity.getPassword()+ "'");
        }if(sysAdminAccountEntity.getHeadUrl()!=null){
            hq.append(",s.headUrl= '"+sysAdminAccountEntity.getHeadUrl()+ "'");
        }if(sysAdminAccountEntity.getUserName()!=null){
            hq.append(",s.userName= '"+sysAdminAccountEntity.getUserName()+ "'");
        }if(sysAdminAccountEntity.getPermission()!=null){
            hq.append(",s.permission= '"+sysAdminAccountEntity.getPermission()+ "'");
        }if(sysAdminAccountEntity.getLastLoginTime()!=null){
            hq.append(",s.lastLoginTime= '"+sysAdminAccountEntity.getLastLoginTime()+ "'");
        }if(sysAdminAccountEntity.getIsBanded()!=null){
            hq.append(",s.isBanded= '"+sysAdminAccountEntity.getIsBanded()+ "'");
        }if(sysAdminAccountEntity.getIsActive()!=null){
            hq.append(",s.isActive= '"+sysAdminAccountEntity.getIsActive()+ "'");
        }if(sysAdminAccountEntity.getCreatedUser()!=null){
            hq.append(",s.createdUser= '"+sysAdminAccountEntity.getCreatedUser()+ "'");
        }if(sysAdminAccountEntity.getCreatedTime()!=null){
            hq.append(",s.createdTime= '"+sysAdminAccountEntity.getCreatedTime()+ "'");
        }if(sysAdminAccountEntity.getModifiedUser()!=null){
            hq.append(",s.modifiedUser= '"+sysAdminAccountEntity.getModifiedUser()+ "'");
        }if(sysAdminAccountEntity.getModifiedTime()!=null){
            hq.append(",s.modifiedTime= '"+sysAdminAccountEntity.getModifiedTime()+ "'");
        }
     String  hql=hq + " where s.no =" + sysAdminAccountEntity.getNo() + "";
        return  this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate()> 0?this.findByno(sysAdminAccountEntity.getNo()):null;
    }

    @Override
    public void delete(SysAdminAccountEntity sysAdminAccountEntity) {
           super.delete(sysAdminAccountEntity);
    }

    @Override
    public SysAdminAccountEntity findByUserId(String userId) {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(SysAdminAccountEntity.class);
        criteria.add(Restrictions.eq("userId",userId));
        return criteria!=null?(SysAdminAccountEntity) criteria.list().get(0):null;
    }

    @Override
    public SysAdminAccountEntity findByno(Integer no) {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(SysAdminAccountEntity.class);
        criteria.add(Restrictions.eq("no",no));
        return criteria!=null?(SysAdminAccountEntity) criteria.list().get(0):null;

    }

    @Override
    public List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize) {
        String sql=new String("select p from SysAdminAccountEntity p where 1=1");
        List<SysAdminAccountEntity> sysAdminAccountEntities=new ArrayList<SysAdminAccountEntity>();
        if(pageNo!=null) {
            sysAdminAccountEntities =this.sessionFactory.getCurrentSession().createQuery(sql).setFirstResult((pageNo - 1) * pageSize)
                    .setMaxResults(pageSize).list();

        }else {
            sysAdminAccountEntities = this.sessionFactory.getCurrentSession().createQuery(sql).list();
        }
        return sysAdminAccountEntities!=null&&sysAdminAccountEntities.size()>0?sysAdminAccountEntities:null;
    }

    @Override
    public SysAdminAccountEntity verifyAdmin(String account,String  password) {
        List<SysAdminAccountEntity> list=this.sessionFactory.getCurrentSession().createQuery("select a from SysAdminAccountEntity a where a.account=? and a.password=? ").setParameter(0,account).setParameter(1,password).list();
        return list!=null&&list.size()>0?list.get(0):null;
    }
}
