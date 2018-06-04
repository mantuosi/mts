package com.mantuosi.mts.core.bean.users;

import java.io.Serializable;

public class Users implements Serializable {
    private String uid;

    private String uname;

    private String upassport;

    private String uaddr;

    private String urank;

    private static final long serialVersionUID = 1L;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassport() {
        return upassport;
    }

    public void setUpassport(String upassport) {
        this.upassport = upassport == null ? null : upassport.trim();
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr == null ? null : uaddr.trim();
    }

    public String getUrank() {
        return urank;
    }

    public void setUrank(String urank) {
        this.urank = urank == null ? null : urank.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", uname=").append(uname);
        sb.append(", upassport=").append(upassport);
        sb.append(", uaddr=").append(uaddr);
        sb.append(", urank=").append(urank);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}