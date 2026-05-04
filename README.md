// EstimationService.java में डाल दे
public class EstimationService {
    
    // ML Model V1: Rule Based | V2: Python Integration बाद में
    public EstimationResponse predictWaste(ProjectRequest req) {
        double area = req.getArea();
        int floors = req.getFloors();
        String type = req.getMepType();
        
        // ML Training Data: 18 साल का Experience
        double wasteFactor = 0.0;
        
        // Feature 1: High-rise Penalty
        if(floors > 15) wasteFactor += 3.5;
        else if(floors > 8) wasteFactor += 2.0;
        
        // Feature 2: MEP Type Weight
        switch(type) {
            case "HVAC": wasteFactor += 7.2; break;     // Duct Wastage
            case "Electrical": wasteFactor += 4.5; break; // Cable Wastage
            case "Plumbing": wasteFactor += 5.8; break;  // Pipe Cutting
        }
        
        // Feature 3: Area Based Learning
        if(area > 100000) wasteFactor += 2.0; // Large Site = More Waste
        
        double predictedWastePercent = 5.0 + wasteFactor; // Base 5%
        double mepCostPerSqft = 2200; // Bangalore Rate
        double totalSaving = (area * mepCostPerSqft * predictedWastePercent) / 100;
        
        String recommendation = "ML Suggestion: Use BIM + Prefabrication to reduce " 
                              + predictedWastePercent + "% waste";
        
        return new EstimationResponse(predictedWastePercent, totalSaving, recommendation);
    }
}
