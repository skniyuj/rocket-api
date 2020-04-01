package com.rocket.poc.rocketapi.cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class CallDetail {
    @PrimaryKey
    private int hostid;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int callid;
    private String dst;
    private String src;
    private double mos;
    public int getCallid() {
        return callid;
    }
    public void setCallid(int callid) {
        this.callid = callid;
    }
    public int getHostid() {
        return hostid;
    }
    public void setHostid(int hostid) {
        this.hostid = hostid;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public String getDst() {
        return dst;
    }
    public void setDst(String dst) {
        this.dst = dst;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public double getMos() {
        return mos;
    }
    public void setMos(double mos) {
        this.mos = mos;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + callid;
        result = prime * result + day;
        result = prime * result + ((dst == null) ? 0 : dst.hashCode());
        result = prime * result + hostid;
        result = prime * result + hour;
        result = prime * result + month;
        long temp;
        temp = Double.doubleToLongBits(mos);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((src == null) ? 0 : src.hashCode());
        result = prime * result + year;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CallDetail other = (CallDetail) obj;
        if (callid != other.callid)
            return false;
        if (day != other.day)
            return false;
        if (dst == null) {
            if (other.dst != null)
                return false;
        } else if (!dst.equals(other.dst))
            return false;
        if (hostid != other.hostid)
            return false;
        if (hour != other.hour)
            return false;
        if (month != other.month)
            return false;
        if (Double.doubleToLongBits(mos) != Double.doubleToLongBits(other.mos))
            return false;
        if (src == null) {
            if (other.src != null)
                return false;
        } else if (!src.equals(other.src))
            return false;
        if (year != other.year)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "CallDetail [callid=" + callid + ", hostid=" + hostid + ", year=" + year + ", month=" + month + ", day="
                + day + ", hour=" + hour + ", dst=" + dst + ", src=" + src + ", mos=" + mos + "]";
    }
}
