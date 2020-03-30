package com.rocket.poc.rocketapi.dummy;

import java.util.Date;

public class MockCall {
    long callId;
    Date time;
    String src;
    String dest;
    float mos;
    public MockCall(long callId, Date time, String src, String dest, float mos) {
        super();
        this.callId = callId;
        this.time = time;
        this.src = src;
        this.dest = dest;
        this.mos = mos;
    }
    public long getCallId() {
        return callId;
    }
    public void setCallId(long callId) {
        this.callId = callId;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }
    public float getMos() {
        return mos;
    }
    public void setMos(float mos) {
        this.mos = mos;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (callId ^ (callId >>> 32));
        result = prime * result + ((dest == null) ? 0 : dest.hashCode());
        result = prime * result + Float.floatToIntBits(mos);
        result = prime * result + ((src == null) ? 0 : src.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        MockCall other = (MockCall) obj;
        if (callId != other.callId)
            return false;
        if (dest == null) {
            if (other.dest != null)
                return false;
        } else if (!dest.equals(other.dest))
            return false;
        if (Float.floatToIntBits(mos) != Float.floatToIntBits(other.mos))
            return false;
        if (src == null) {
            if (other.src != null)
                return false;
        } else if (!src.equals(other.src))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "MockCall [callId=" + callId + ", time=" + time + ", src=" + src + ", dest=" + dest + ", mos=" + mos
                + "]";
    }
}
