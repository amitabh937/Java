package com.amit.mep.controller;

import com.amit.mep.service.EstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MepController {
    
    @Autowired
    private EstimationService estimationService;
    
    @PostMapping("/estimate")
    public EstimationResponse getEstimation(@RequestBody ProjectRequest request) {
        return estimationService.calculateWaste(request);
    }
    
    @GetMapping("/health")
    public String healthCheck() {
        return "MEP-Cost-Optimizer by Amit Kumar is Running! ML Model V1 Active";
    }
}
