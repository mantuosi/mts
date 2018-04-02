package com.mantuosi.mts.core.bean.message;

import java.io.Serializable;
import java.util.Date;

public class MessageReply implements Serializable {
    private Integer id;

    /**
     * 被回复者Id
     */
    private Integer userid;

    /**
     * 回复者Id
     */
    private Integer replyerid;

    private Date replytime;

    private String replytext;

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

    public Integer getReplyerid() {
        return replyerid;
    }

    public void setReplyerid(Integer replyerid) {
        this.replyerid = replyerid;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getReplytext() {
        return replytext;
    }

    public void setReplytext(String replytext) {
        this.replytext = replytext == null ? null : replytext.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", replyerid=").append(replyerid);
        sb.append(", replytime=").append(replytime);
        sb.append(", replytext=").append(replytext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}