package com.saltbrook.datamodel.persistence;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//TODO: clarify which table columns are required for the business logic
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
@Table(name = "RECURRING_REVENUE")
public class RecurringRevenue extends BaseEntity {
	
	@Id
	@Column
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate createDate;
	
	@Column(nullable = false)
	private LocalDate chargeMonth;
	
	@Column(nullable = false)
	private Float amount;
	
	@Column
	private String serviceType;
	
	@Column
	private String assetId;
	
	@Column
	private String accountId;

}
