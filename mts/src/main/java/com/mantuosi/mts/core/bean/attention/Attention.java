package com.mantuosi.mts.core.bean.attention;

import java.io.Serializable;

public class Attention implements Serializable {
    private Integer id;

    private Integer userid;

    /**
     * 被关注人Id
     */
    private Integer userAttentiontoid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserAttentiontoid() {
        return userAttentiontoid;
    }

    public void setUserAttentiontoid(Integer userAttentiontoid) {
        this.userAttentiontoid = userAttentiontoid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", userAttentiontoid=").append(userAttentiontoid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}