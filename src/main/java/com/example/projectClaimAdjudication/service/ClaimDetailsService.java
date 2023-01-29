package com.example.projectClaimAdjudication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.ClaimDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.repository.ClaimDetailsRepository;
import com.example.projectClaimAdjudication.repository.MedicalInsurancePlanRepository;

@Service
public class ClaimDetailsService {
	
	@Autowired
	ClaimDetailsRepository claimDetailsRepository;
	
	@Autowired
	MedicalInsurancePlanRepository medicalInsurancePlanRepository;
	
	public void saveOrUpdateClaimDetails(ClaimDetails claimDetails) {
		
    	Float dft = claimDetails.getDrugCost() + claimDetails.getFee() + claimDetails.getTax();
    	Float remainingDeductableAmount = claimDetails.getMemberPlanDetails().getRemainingDeductableAmount();
    	Float remainingOutOfPocketAmount = claimDetails.getMemberPlanDetails().getRemainingOutOfPocketAmount();
    	Float copay = 0.0f;
    	Float planPay = 0.0f;
    	Float speciality = medicalInsurancePlanRepository.findSpecialityByPlanId(claimDetails.getMemberPlanDetails().getPlanId())/100;
    	
    	if(dft <= remainingDeductableAmount) {
    		copay = dft;
    		claimDetails.getMemberPlanDetails().setRemainingDeductableAmount(remainingDeductableAmount - copay);
    	} else if(dft > remainingDeductableAmount) { 
    		copay =  (remainingDeductableAmount + ((dft - remainingDeductableAmount) * speciality));
    		
    		if(copay > remainingOutOfPocketAmount) {
    			copay = remainingDeductableAmount + remainingOutOfPocketAmount;
    			claimDetails.getMemberPlanDetails().setRemainingOutOfPocketAmount(0.0f);
    		} else {
    			claimDetails.getMemberPlanDetails().setRemainingOutOfPocketAmount(remainingOutOfPocketAmount - ((dft - remainingDeductableAmount) * speciality));
    		}
    	
    		claimDetails.getMemberPlanDetails().setRemainingDeductableAmount(0.0f);
    	} 
    	
    	planPay = dft - copay;
    	claimDetails.setCopay(copay);
    	claimDetails.setPlanPay(planPay);
    	
		claimDetailsRepository.save(claimDetails);
	}

	public ClaimDetails getClaimDetails(int id) {
		return claimDetailsRepository.findById(id).get();
	}

	public List<ClaimDetails> getClaimDetailsByMemberPlanId(MemberPlanDetails memberPlanId) {

		return claimDetailsRepository.findByMemberPlanDetails(memberPlanId);
	}	
}
