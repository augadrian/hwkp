package com.hwkp.dao.Impl;

import com.hwkp.dao.AdvDao;
import com.hwkp.dao.BaseDao;
import com.hwkp.entity.AdvEntity;
import com.hwkp.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by augadrian on 2018/11/15.
 */
@Repository
public class AdvDaoImpl extends BaseDaoImpl<AdvEntity> implements AdvDao {

    @Override
    public AdvEntity update(AdvEntity advEntity) {
        StringBuffer hq=new StringBuffer("update AdvEntity b set id = id");
        if(advEntity.getType()!=null){
            hq.append(",b.type= '"+advEntity.getType()+ "'");
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
        }
        String hql=hq + " where a.id =" + advEntity.getId() + "";
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
    public List<AdvEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
