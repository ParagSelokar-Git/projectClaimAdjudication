package com.example.projectClaimAdjudication.model;

import java.util.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name = "Claim_Details")
public class ClaimDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer claimId;
//	private Integer memberPlanId;
	private Integer drugId;
	private Float drugCost;
	private Float fee;
	private Float tax;
	private Float copay;
	private Float planPay;	
	private Date claimDate;
	private String claimType;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_plan_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MemberPlanDetails memberPlanDetails;
}
