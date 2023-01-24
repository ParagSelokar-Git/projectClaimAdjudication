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
import com.example.projectClaimAdjudication.service.MedicalInsurancePlanService;

@RestController
public class MedicalInsurancePlanController {

	@Autowired
	MedicalInsurancePlanService medicalInsurancePlanService;

	@GetMapping("/medicalInsurancePlan")
	private List<MedicalInsurancePlan> getAllMedicalInsurancePlan() {
		return medicalInsurancePlanService.getAllMedicalInsurancePlans();
	}

	@GetMapping("/medicalInsurancePlan/{id}")
	private MedicalInsurancePlan getMedicalInsurancePlan(@PathVariable("id") int id) {
		return medicalInsurancePlanService.getMedicalInsurancePlanById(id);
	}

	@DeleteMapping("/medicalInsurancePlan/{id}")
	private void deleteMedicalInsurancePlan(@PathVariable("id") int id) {
		medicalInsurancePlanService.delete(id);
	}

	@PostMapping("/medicalInsurancePlan")
	private int saveMedicalInsurancePlan(@RequestBody MedicalInsurancePlan medicalInsurancePlan) {
		medicalInsurancePlanService.saveOrUpdateMedicalInsurancePlan(medicalInsurancePlan);
		return medicalInsurancePlan.getPlanId();
	}

}
