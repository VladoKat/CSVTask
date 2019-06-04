package com.personal.model;

public class Salesman {
    private String name;
    private Integer totalSales;
    private Double experienceMultiplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }
}
