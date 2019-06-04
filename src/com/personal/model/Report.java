package com.personal.model;

public class Report {
    private Integer topPerformersThreshold;
    private boolean useExperienceMultiplier;
    private Integer periodLimit;

    public Integer getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    public void setTopPerformersThreshold(Integer topPerformersThreshold) {
        this.topPerformersThreshold = topPerformersThreshold;
    }

    public boolean isUseExperienceMultiplier() {
        return useExperienceMultiplier;
    }

    public void setUseExperienceMultiplier(boolean useExperienceMultiplier) {
        this.useExperienceMultiplier = useExperienceMultiplier;
    }

    public Integer getPeriodLimit() {
        return periodLimit;
    }

    public void setPeriodLimit(Integer periodLimit) {
        this.periodLimit = periodLimit;
    }
}
