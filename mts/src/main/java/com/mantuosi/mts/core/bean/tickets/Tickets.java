package com.mantuosi.mts.core.bean.tickets;

import java.io.Serializable;

public class Tickets implements Serializable {
    private String tid;

    private String departureAdd;

    private String destinationAdd;

    private String departureTime;

    private String arrivalTime;

    private Float price;

    private String uid;

    private static final long serialVersionUID = 1L;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getDepartureAdd() {
        return departureAdd;
    }

    public void setDepartureAdd(String departureAdd) {
        this.departureAdd = departureAdd == null ? null : departureAdd.trim();
    }

    public String getDestinationAdd() {
        return destinationAdd;
    }

    public void setDestinationAdd(String destinationAdd) {
        this.destinationAdd = destinationAdd == null ? null : destinationAdd.trim();
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime == null ? null : departureTime.trim();
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime == null ? null : arrivalTime.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", departureAdd=").append(departureAdd);
        sb.append(", destinationAdd=").append(destinationAdd);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", price=").append(price);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}