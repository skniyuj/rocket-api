package com.rocket.poc.rocketapi.cassandra;

public class HourlyAvgMOS {
    private int year;
    private int month;
    private int day;
    private int hour;
    private double mos;

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
        result = prime * result + year;
        result = prime * result + month;
        result = prime * result + day;
        result = prime * result + hour;
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
        HourlyAvgMOS other = (HourlyAvgMOS) obj;
        if (year != other.year)
            return false;
        if (month != other.month)
            return false;
        if (day != other.day)
            return false;
        if (hour != other.hour)
            return false;
        if (Double.doubleToLongBits(mos) != Double.doubleToLongBits(other.mos))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "HourlyAvgMOS [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", mos=" + mos + "]";
    }
}
