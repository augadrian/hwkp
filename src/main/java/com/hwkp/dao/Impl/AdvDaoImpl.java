package com.hwkp.dao.Impl;

import com.hwkp.dao.AdvDao;
import com.hwkp.dao.BaseDao;
import com.hwkp.entity.AdvEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Repository
public class AdvDaoImpl extends BaseDaoImpl<AdvEntity> implements AdvDao {

    @Override
    public AdvEntity update(AdvEntity advEntity) {
        StringBuffer hq=new StringBuffer("update AdvEntity b set");
        if(advEntity.getType()!=null){
            hq.append(" b.type= '"+advEntity.getType()+ "'");
        }if(advEntity.getAdvertise()!=null){
            hq.append(",b.advertise= '"+advEntity.getAdvertise()+ "'");
        } if(advEntity.getCreatedTime()!=null){
            hq.append(",b.createdTime= '"+advEntity.getCreatedTime()+ "'");
        } if(advEntity.getCreatedUser()!=null){
            hq.append(",b.createdUser= '"+advEntity.getCreatedUser()+ "'");
        } if(advEntity.getIsActive()!=null){
            hq.append(",b.isActive= '"+advEntity.getIsActive()+ "'");
        } if(advEntity.getModifiedTime()!=null){
            hq.append(",b.modifiedTime= '"+advEntity.getModifiedTime()+ "'");
        } if(advEntity.getModifiedUser()!=null){
            hq.append(",b.modifiedUser= '"+advEntity.getModifiedUser()+ "'");
        }if(advEntity.getPosition()!=null){
            hq.append(",b.position= '"+advEntity.getPosition()+ "'");
        }
        String hql=hq + " where b.id =" + advEntity.getId() + "";
        return this.sessionFactory.getCurrentSession().createQuery(hql).executeUpdate()>0?this.findById(advEntity.getId()):null;
    }
    @Override
     public void save(AdvEntity advEntity){
        super.save(advEntity);
        }


    @Override
    public void delete(AdvEntity advEntity) {
    super.delete(advEntity);
    }

    @Override
    public AdvEntity findById(Integer id) {
        return (AdvEntity)super.findById(AdvEntity.class,id);
    }

    @Override
    public List<AdvEntity> findAll(Integer pageNo, Integer pageSize) {
        String sql=new String("select p from AdvEntity p where 1=1");
        List<AdvEntity> advEntities=new ArrayList<AdvEntity>();
        if(pageNo!=null) {
            advEntities =this.sessionFactory.getCurrentSession().createQuery(sql).setFirstResult((pageNo - 1) * pageSize)
                    .setMaxResults(pageSize).list();;

        }else {
            advEntities = this.sessionFactory.getCurrentSession().createQuery(sql).list();
        }
        return advEntities!=null&&advEntities.size()>0?advEntities:null;

    }
}
