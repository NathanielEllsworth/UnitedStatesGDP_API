package com.ironyard.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nathanielellsworth on 11/7/16.
 */

public class USAGDP {

    @JsonProperty(value = "area_name")
    private String area_name;

    @JsonProperty(value = "measurement")
    private String measurement;

    @JsonProperty(value = "value")
    private String value;

    @JsonProperty(value = "year")
    private int year;

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
