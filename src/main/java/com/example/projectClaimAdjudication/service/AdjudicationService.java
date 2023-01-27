package com.example.projectClaimAdjudication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.ClaimDetails;
import com.example.projectClaimAdjudication.model.MedicalInsurancePlan;
import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.repository.AdjudicationRepository;
import com.example.projectClaimAdjudication.repository.MemberDetailsRepository;
import com.example.projectClaimAdjudication.repository.MemberPlanDetailsRepository;

@Service
public class AdjudicationService {


    @Autowired
    AdjudicationRepository adjudicationRepository;
    
    @Autowired
    MemberDetailsRepository memberDetailsRepository;
    
    @Autowired
    MemberPlanDetailsRepository memberPlanDetailsRepository;

//    public List<MedicalInsurancePlan> getAllMedicalInsurancePlans() {
//        List<MedicalInsurancePlan> medicalInsurancePlanList = new ArrayList<MedicalInsurancePlan>();
//        adjudicationRepository.findAll().forEach(medicalInsurancePlan -> medicalInsurancePlanList.add(medicalInsurancePlan));
//        return medicalInsurancePlanList;
//    }
//
//    public MedicalInsurancePlan getMedicalInsurancePlanById(int id) {
//        return adjudicationRepository.findById(id).get();
//    }
//
//    public void saveOrUpdateMedicalInsurancePlan(MedicalInsurancePlan medicalInsurancePlan) {
//    	adjudicationRepository.save(medicalInsurancePlan);
//    }
    
    public void saveOrUpdateMemberDetails(MemberDetails memberDetails) {
    	memberDetailsRepository.save(memberDetails);
    }
    public MemberDetails getMemberDetailsById(int id) {
        return memberDetailsRepository.findById(id).get();
    }

    public void saveOrUpdateMemberPlanDetails(MemberPlanDetails memberPlanDetails) {
    	memberPlanDetailsRepository.save(memberPlanDetails);
    }
    
    public MemberPlanDetails getMemberPlanDetails(int id) {
    	return memberPlanDetailsRepository.findById(id).get();
    }
    
    public List<MemberPlanDetails> getMemberPlanDetailsByMemberId(MemberDetails memberId) {
    	
    	return memberPlanDetailsRepository.findByMemberDetail(memberId);
    }
    
    public MemberPlanDetails settleClaim(ClaimDetails claimDetails) {
    	MemberPlanDetails memberPlanDetails = memberPlanDetailsRepository.findById(claimDetails.getMemberPlanId()).get();
    	Float dft = claimDetails.getDrugCost() + claimDetails.getFee() + claimDetails.getTax();
    	Float remainingDeductableAmount = memberPlanDetails.getRemainingDeductableAmount();
    	Float remainingOutOfPocketAmount = memberPlanDetails.getRemainingOutOfPocketAmount();
    	Float copay = (float) 0.0;
    	Float planPay = (float) 0.0;
    	if(dft <= remainingDeductableAmount) {
    		copay = dft;
    		memberPlanDetails.setRemainingDeductableAmount(remainingDeductableAmount - copay);
    	} else if(dft > remainingDeductableAmount && remainingOutOfPocketAmount != 0 ) { 
    		copay =  (float) (remainingDeductableAmount + ((dft - remainingDeductableAmount)*0.20));
    		
    		if(copay > remainingOutOfPocketAmount) 
    			copay = remainingDeductableAmount + remainingOutOfPocketAmount;
    	
    		memberPlanDetails.setRemainingDeductableAmount((float) 0.0);
    		memberPlanDetails.setRemainingOutOfPocketAmount(remainingOutOfPocketAmount - copay);
    	} 
    	planPay = dft - copay;
    	return claimDetails;
    }
    
//    public void delete(int id) {
//    	adjudicationRepository.deleteById(id);
//    }
	
}
