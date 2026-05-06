package com.amit.mep.service;

import org.springframework.stereotype.Service;

@Service
public class EstimationService {
    
    // ML Model V1: Rule Based on 18 Years Site Experience
    public EstimationResponse calculateWaste(ProjectRequest req) {
        double area = req.getArea();
        int floors = req.getFloors();
        String mepType = req.getMepType().toUpperCase();
        
        double baseWaste = 5.0; // Minimum 5% waste in any project
        double wasteFactor = 0.0;
        
        // Feature 1: High-rise Learning
        if(floors > 20) wasteFactor += 4.0;
        else if(floors > 10) wasteFactor += 2.5;
        else if(floors > 5) wasteFactor += 1.0;
        
        // Feature 2: MEP Type Weight - Based on real site data
        switch(mepType) {
            case "HVAC": 
                wasteFactor += 7.0; // Duct cutting, insulation waste
                break;
            case "PLUMBING": 
                wasteFactor += 5.5; // Pipe cutting, fittings
                break;
            case "ELECTRICAL": 
                wasteFactor += 4.0; // Cable cutting, conduit
                break;
            case "FIRE-FIGHTING": 
                wasteFactor += 3.5;
                break;
            default: 
                wasteFactor += 3.0;
        }
        
        // Feature 3: Area Based Complexity
        if(area > 200000) wasteFactor += 3.0; // Mega projects
        else if(area > 100000) wasteFactor += 2.0;
        else if(area > 50000) wasteFactor += 1.0;
        
        double predictedWastePercent = baseWaste + wasteFactor;
        if(predictedWastePercent > 25.0) predictedWastePercent = 25.0; // Cap at 25%
        
        // Business Calculation
        double mepCostPerSqft = 2500; // Bangalore/Delhi avg rate
        double totalMepCost = area * mepCostPerSqft;
        double wastedAmount = (totalMepCost * predictedWastePercent) / 100;
        
        String recommendation = "ML Suggestion: Use BIM + Prefabrication. " +
                "Predicted " + String.format("%.1f", predictedWastePercent) + 
                "% waste can be reduced to 5% by adopting modular construction.";
        
        return new EstimationResponse(
            predictedWastePercent, 
            wastedAmount, 
            totalMepCost,
            recommendation
        );
    }
}
