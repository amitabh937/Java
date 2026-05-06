package com.amit.mep.service;

public class EstimationResponse {
    private double wastePercent;
    private double savingAmountINR;
    private double totalProjectCost;
    private String recommendation;
    
    public EstimationResponse(double wastePercent, double savingAmountINR, 
                              double totalProjectCost, String recommendation) {
        this.wastePercent = wastePercent;
        this.savingAmountINR = savingAmountINR;
        this.totalProjectCost = totalProjectCost;
        this.recommendation = recommendation;
    }
    
    // Getters
    public double getWastePercent() { return wastePercent; }
    public double getSavingAmountINR() { return savingAmountINR; }
    public double getTotalProjectCost() { return totalProjectCost; }
    public String getRecommendation() { return recommendation; }
}
