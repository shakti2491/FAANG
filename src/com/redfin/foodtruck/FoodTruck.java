package com.redfin.foodtruck;

public class FoodTruck
{
    private String dayorder;
    private String dayofweekstr;
    private String starttime;
    private String endtime;
    private String permit;
    private String location;
    private String applicant;

    public String getDayorder()
    {
        return dayorder;
    }

    public void setDayorder(String dayorder)
    {
        this.dayorder = dayorder;
    }

    public String getDayofweekstr()
    {
        return dayofweekstr;
    }

    public void setDayofweekstr(String dayofweekstr)
    {
        this.dayofweekstr = dayofweekstr;
    }

    public String getStarttime()
    {
        return starttime;
    }

    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }

    public String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    public String getPermit()
    {
        return permit;
    }

    public void setPermit(String permit)
    {
        this.permit = permit;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getApplicant()
    {
        return applicant;
    }

    public void setApplicant(String applicant)
    {
        this.applicant = applicant;
    }
}
