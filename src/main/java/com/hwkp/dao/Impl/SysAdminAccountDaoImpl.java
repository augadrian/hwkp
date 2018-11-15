package com.hwkp.dao.Impl;

import com.hwkp.dao.SysAdminAccountDao;
import com.hwkp.entity.SysAdminAccountEntity;
import org.springframework.stereotype.Repository;

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
    public void update(SysAdminAccountEntity sysAdminAccountEntity) {
        StringBuffer hq=new StringBuffer("update sys_admin_account s set no=no");
        if(sysAdminAccountEntity.getUserId()!=null){
            hq.append(",s.user_id="+sysAdminAccountEntity.getUserId());
        }if(sysAdminAccountEntity.getWxOpenid()!=null){
            hq.append(",s.wx_openid="+sysAdminAccountEntity.getWxOpenid());
        }if(sysAdminAccountEntity.getAccount()!=null){
            hq.append(",s.account="+sysAdminAccountEntity.getAccount());
        }if(sysAdminAccountEntity.getPassword()!=null){
            hq.append(",s.password="+sysAdminAccountEntity.getPassword());
        }if(sysAdminAccountEntity.getHeadUrl()!=null){
            hq.append(",s.head_url="+sysAdminAccountEntity.getHeadUrl());
        }if(sysAdminAccountEntity.getUserName()!=null){
            hq.append(",s.user_name="+sysAdminAccountEntity.getUserName());
        }if(sysAdminAccountEntity.getPermission()!=null){
            hq.append(",s.permission="+sysAdminAccountEntity.getPermission());
        }if(sysAdminAccountEntity.getLastLoginTime()!=null){
            hq.append(",s.last_login_time="+sysAdminAccountEntity.getLastLoginTime());
        }if(sysAdminAccountEntity.getIsBanded()!=null){
            hq.append(",s.is_banded="+sysAdminAccountEntity.getIsBanded());
        }if(sysAdminAccountEntity.getIsActive()!=null){
            hq.append(",s.is_active="+sysAdminAccountEntity.getIsActive());
        }if(sysAdminAccountEntity.getCreatedUser()!=null){
            hq.append(",s.created_user="+sysAdminAccountEntity.getCreatedUser());
        }if(sysAdminAccountEntity.getCreatedTime()!=null){
            hq.append(",s.created_time="+sysAdminAccountEntity.getCreatedTime());
        }if(sysAdminAccountEntity.getModifiedUser()!=null){
            hq.append(",s.modified_user="+sysAdminAccountEntity.getModifiedUser());
        }if(sysAdminAccountEntity.getModifiedTime()!=null){
            hq.append(",s.modified_time="+sysAdminAccountEntity.getModifiedTime());
        }
    }

    @Override
    public void delete(SysAdminAccountEntity sysAdminAccountEntity) {
           super.delete(sysAdminAccountEntity);
    }

    @Override
    public SysAdminAccountEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<SysAdminAccountEntity> findAll(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        return null;
    }
}
