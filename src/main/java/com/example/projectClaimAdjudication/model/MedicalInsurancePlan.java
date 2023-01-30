package com.example.projectClaimAdjudication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
