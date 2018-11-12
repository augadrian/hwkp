package com.hwkp.model;

public class invite {
    private Integer id;
    private String inviter_id;//邀请者ID
    private String invited_id;//被邀请者ID
    private float total_commission;//好友为我累计赚取佣金
    private Integer is_active;
    private String created_user;//
    private String created_time;//
    private String modified_user;//
    private String modified_time;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInviter_id() {
        return inviter_id;
    }

    public void setInviter_id(String inviter_id) {
        this.inviter_id = inviter_id;
    }

    public String getInvited_id() {
        return invited_id;
    }

    public void setInvited_id(String invited_id) {
        this.invited_id = invited_id;
    }

    public float getTotal_commission() {
        return total_commission;
    }

    public void setTotal_commission(float total_commission) {
        this.total_commission = total_commission;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getModified_user() {
        return modified_user;
    }

    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }
}

