package com.example.projectClaimAdjudication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectClaimAdjudication.model.MedicalInsurancePlan;
import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.service.AdjudicationService;

@RestController
public class AdjudicationController {

    @Autowired
    AdjudicationService adjudicationService;
    

    @GetMapping("/medicalInsurancePlan")
    private List<MedicalInsurancePlan> getAllMedicalInsurancePlan() {
        return adjudicationService.getAllMedicalInsurancePlans();
    }

    @GetMapping("/medicalInsurancePlan/{id}")
    private MedicalInsurancePlan getMedicalInsurancePlan(@PathVariable("id") int id) {
        return adjudicationService.getMedicalInsurancePlanById(id);
    }

    @DeleteMapping("/medicalInsurancePlan/{id}")
    private void deleteMedicalInsurancePlan(@PathVariable("id") int id) {
        adjudicationService.delete(id);
    }

    @PostMapping("/medicalInsurancePlan")
    private int saveMedicalInsurancePlan(@RequestBody MedicalInsurancePlan medicalInsurancePlan) {
    	adjudicationService.saveOrUpdateMedicalInsurancePlan(medicalInsurancePlan);
        return medicalInsurancePlan.getPlanId();
    }
    
    @PostMapping("/memberDetails")
    private int saveOrUpdateMemberDetails(@RequestBody MemberDetails memberDetails) {
    	adjudicationService.saveOrUpdateMemberDetails(memberDetails);
        return memberDetails.getMemberId();
    }
    
    @GetMapping("/memberDetails/{id}")
    private MemberDetails getMemberDetails(@PathVariable("id") int id) {
    	return adjudicationService.getMemberDetailsById(id);
    }
    
    @PostMapping("/memberPlanDetails")
    private int saveOrUpdateMemberPlanDetails(@RequestBody MemberPlanDetails memberPlanDetails) {
    	adjudicationService.saveOrUpdateMemberPlanDetails(memberPlanDetails);
        return memberPlanDetails.getMemberPlanId();
    }
}
