package com.example.projectClaimAdjudication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "MEDICAL_INSURANCE_PLAN")
public class MedicalInsurancePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	private String planName;
	private String planType;
	private Float planAmount;
	private Float deductableAmount;
	private Float outOfPocketAmount;
	private Float speciality;
	private Integer duration;
	private String status;
}
