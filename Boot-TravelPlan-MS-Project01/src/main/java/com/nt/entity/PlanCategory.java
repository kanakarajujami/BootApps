package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
@Id	
@Column(name="CATEGORY_ID")
@SequenceGenerator(name="gen1",sequenceName="category_deq",initialValue=10000,allocationSize=1)
@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
private Integer categoryId;
@Column(name="CATEGORY_NAME")
private String categoryName;
@Column(name="ACTIVE_SW")
private String activeSW;
@CreationTimestamp
@Column(name="CREATED_DATE")
private LocalDateTime createdDate;
@UpdateTimestamp
@Column(name="UPDATED_DATE")
private LocalDateTime updatedTime;
@Column(name="CREATED_BY")
private String createdBy;
@Column(name="UPDATED_BY")
private String updatedBy;
}
