package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TRAVEL_PLAN")
@Data
public class TravelPlan {
@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="PLAN_ID")
private Integer planId;
@Column(name="PLAN_NAME")
private String planName;
@Column(name="PLAN_MIN_BUDGET")
private Float planMinBudget;
@Column(name="PLAN_DESCRIPTION")
private String planDescription;
@Column(name="PLAN_CATEGORY_ID")
private Integer planCategoryId;
@CreationTimestamp
@Column(name="CREATED_DATE")
private LocalDateTime createdDate;
@UpdateTimestamp
@Column(name="UPDATED_TIME")
private LocalDateTime updatedTime;
@Column(name="CREATED_BY")
private String createdBy;
@Column(name="UPDATED_BY")
private String updatedBy;
@Column(name="ACTIVE_SW")
private String activeSW;

}
