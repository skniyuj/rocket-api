package com.rocket.poc.rocketapi.cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class CallRecord {
    @PrimaryKey
    private int callid;
    private String src;
    private String dst;
    private double mos;

    public int getCallid() {
        return callid;
    }
    public void setCallid(int callid) {
        this.callid = callid;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getDst() {
        return dst;
    }
    public void setDst(String dst) {
        this.dst = dst;
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
        result = prime * result + ((src == null) ? 0 : src.hashCode());
        result = prime * result + ((dst == null) ? 0 : dst.hashCode());
        long temp;
        temp = Double.doubleToLongBits(mos);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        CallRecord other = (CallRecord) obj;
        if (callid != other.callid)
            return false;
        if (dst == null) {
            if (other.dst != null)
                return false;
        } else if (!dst.equals(other.dst))
            return false;
        if (Double.doubleToLongBits(mos) != Double.doubleToLongBits(other.mos))
            return false;
        if (src == null) {
            if (other.src != null)
                return false;
        } else if (!src.equals(other.src))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "CallRecord [callid=" + callid + ", src=" + src + ", dst=" + dst + ", mos=" + mos + "]";
    }
}
