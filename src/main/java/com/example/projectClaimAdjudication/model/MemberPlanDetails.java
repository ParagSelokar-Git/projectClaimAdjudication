package com.example.projectClaimAdjudication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Member_Plan_Details")
public class MemberPlanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberPlanId;
//	private Integer memberId;
	private Integer planId;
	private Date startDate;
	private Date endDate;
	private Float remainingDeductableAmount;
	private Float remainingOutOfPocketAmount;
	private String status;
	
//	@ManyToOne
//	private MemberDetails memberDetail;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private MemberDetails memberDetail;
	
	@OneToMany(mappedBy = "memberPlanDetails")
	private List<ClaimDetails> claimDetailsList = new ArrayList<>();
}

