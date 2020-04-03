package com.rocket.poc.rocketapi.cassandra;

public class HourlyCalls {
    private int hour;
    private int count;

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hour;
        result = prime * result + count;
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
        HourlyCalls other = (HourlyCalls) obj;
        if (hour != other.hour)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "HourlyCalls [hour=" + hour + ", count=" + count + "]";
    }
}
