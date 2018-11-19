package com.hwkp.util;

import com.hwkp.entity.SysAdminAccountEntity;

/**
 * Created by sky2080 on 2016/12/22.
 */
public class AdminThreadlocal {
    private static final ThreadLocal<SysAdminAccountEntity> LOCAL=new ThreadLocal<SysAdminAccountEntity>();
    public static void set(SysAdminAccountEntity admin){
        LOCAL.set(admin);
    }
    public static SysAdminAccountEntity get(){
        return LOCAL.get();
    }
}
