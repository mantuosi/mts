package com.mantuosi.mts.core.bean.comment;

import java.io.Serializable;
import java.util.Date;

public class CommentReply implements Serializable {
    private Integer id;

    /**
     * 回复者Id
     */
    private Integer replyerid;

    /**
     * 评论Id
     */
    private Integer commentid;

    private Date replytime;

    /**
     * 回复内容
     */
    private String replytext;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReplyerid() {
        return replyerid;
    }

    public void setReplyerid(Integer replyerid) {
        this.replyerid = replyerid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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
        sb.append(", replyerid=").append(replyerid);
        sb.append(", commentid=").append(commentid);
        sb.append(", replytime=").append(replytime);
        sb.append(", replytext=").append(replytext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}