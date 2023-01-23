package com.example.projectClaimAdjudication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<MedicalInsurancePlan> getAllMedicalInsurancePlans() {
        List<MedicalInsurancePlan> medicalInsurancePlanList = new ArrayList<MedicalInsurancePlan>();
        adjudicationRepository.findAll().forEach(medicalInsurancePlan -> medicalInsurancePlanList.add(medicalInsurancePlan));
        return medicalInsurancePlanList;
    }

    public MedicalInsurancePlan getMedicalInsurancePlanById(int id) {
        return adjudicationRepository.findById(id).get();
    }

    public void saveOrUpdateMedicalInsurancePlan(MedicalInsurancePlan medicalInsurancePlan) {
    	adjudicationRepository.save(medicalInsurancePlan);
    }
    
    public void saveOrUpdateMemberDetails(MemberDetails memberDetails) {
    	memberDetailsRepository.save(memberDetails);
    }
    public MemberDetails getMemberDetailsById(int id) {
        return memberDetailsRepository.findById(id).get();
    }

    public void saveOrUpdateMemberPlanDetails(MemberPlanDetails memberPlanDetails) {
    	memberPlanDetailsRepository.save(memberPlanDetails);
    }
    
    public void delete(int id) {
    	adjudicationRepository.deleteById(id);
    }
	
}
