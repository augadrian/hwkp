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
        StringBuffer hq=new StringBuffer("update b_adv b set id=id");
        if(advEntity.getType()!=null){
            hq.append(",b.type="+advEntity.getType());
        }
        if(advEntity.getAdvertise()!=null){
            hq.append(",b.advertise="+advEntity.getAdvertise());
        } if(advEntity.getCreatedTime()!=null){
            hq.append(",b.created_time="+advEntity.getCreatedTime());
        } if(advEntity.getCreatedUser()!=null){
            hq.append(",b.created_user="+advEntity.getCreatedUser());
        } if(advEntity.getIsActive()!=null){
            hq.append(",b.is_active="+advEntity.getIsActive());
        } if(advEntity.getModifiedTime()!=null){
            hq.append(",b.modified_time="+advEntity.getModifiedTime());
        } if(advEntity.getModifiedUser()!=null){
            hq.append(",b.modified_user="+advEntity.getModifiedUser());
        }
    return null;
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
    public AdvEntity findById(Integer no) {
        return (AdvEntity)super.findById(AdvEntity.class,no);
    }

    @Override
    public List<AdvEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
