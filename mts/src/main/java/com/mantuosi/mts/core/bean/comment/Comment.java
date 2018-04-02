package com.mantuosi.mts.core.bean.comment;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer id;

    /**
     * 被评论用户Id
     */
    private Integer userid;

    /**
     * 评论者Id
     */
    private Integer commenterid;

    private Date commenttime;

    private String text;

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

    public Integer getCommenterid() {
        return commenterid;
    }

    public void setCommenterid(Integer commenterid) {
        this.commenterid = commenterid;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", commenterid=").append(commenterid);
        sb.append(", commenttime=").append(commenttime);
        sb.append(", text=").append(text);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}