package com.personal.model;

public class Salesman {
    private String name;
    private Integer totalSales;
    private Integer salesPeriod;
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

    public Integer getSalesPeriod() {
        return salesPeriod;
    }

    public void setSalesPeriod(Integer salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public Double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }

    public static int customCompare(Salesman s2, Salesman s1){
        return (int) ((s1.getTotalSales().doubleValue()/s1.getSalesPeriod().doubleValue()) - (s2.getTotalSales().doubleValue()/s2.getSalesPeriod().doubleValue()));
    }
}
