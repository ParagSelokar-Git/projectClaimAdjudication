package com.example.projectClaimAdjudication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.MedicalInsurancePlan;
import com.example.projectClaimAdjudication.repository.MedicalInsurancePlanRepository;

@Service
public class MedicalInsurancePlanService {

	@Autowired
	MedicalInsurancePlanRepository medicalInsurancePlanRepository;

	public List<MedicalInsurancePlan> getAllMedicalInsurancePlans() {
		List<MedicalInsurancePlan> medicalInsurancePlanList = new ArrayList<MedicalInsurancePlan>();
		medicalInsurancePlanRepository.findAll()
				.forEach(medicalInsurancePlan -> medicalInsurancePlanList.add(medicalInsurancePlan));
		return medicalInsurancePlanList;
	}

	public MedicalInsurancePlan getMedicalInsurancePlanById(int id) {
		return medicalInsurancePlanRepository.findById(id).get();
	}

	public void saveOrUpdateMedicalInsurancePlan(MedicalInsurancePlan medicalInsurancePlan) {
		medicalInsurancePlanRepository.save(medicalInsurancePlan);
	}

	public void delete(int id) {
		medicalInsurancePlanRepository.deleteById(id);
	}

}
