package com.mantuosi.mts.core.bean.privatemessage;

import java.io.Serializable;

public class Privatemessage implements Serializable {
    private Integer id;

    /**
     * 发信人Id
     */
    private Integer senderid;

    /**
     * 收信人Id
     */
    private Integer receiverid;

    /**
     * 私信标题
     */
    private String title;

    /**
     * 私信内容
     */
    private String text;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
        sb.append(", senderid=").append(senderid);
        sb.append(", receiverid=").append(receiverid);
        sb.append(", title=").append(title);
        sb.append(", text=").append(text);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}