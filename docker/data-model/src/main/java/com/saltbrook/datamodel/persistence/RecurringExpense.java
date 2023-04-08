package com.saltbrook.datamodel.persistence;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

//TODO: clarify which table columns are required for the business logic
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Access(AccessType.FIELD)
@Table(name = "RECURRING_EXPENSE")
public class RecurringExpense {
	
	@Id
	@Column
	private String id;
	
	@Column
	private Boolean active;
	
	@Column
	private Float bandwidth;
	
	@Column
	private String billingProfileId;
	
	@Column
	private String buildingId;
	
	@Column
	private String cfa;
	
	@Column
	private String createdById;
	
	@Column
	private String createdDate;
	
	@Column
	private String focDate;
	
	@Column
	private String governingContract;
	
	@Column
	private String internalWorkOrderId;
	
	@Column
	private Boolean isDeleted;
	
	@Column
	private String lastActivityDate;
	
	@Column
	private String lastModifiedById;
	
	@Column
	private String lastModifiedDate;
	
	@Column
	private Float monthlyRecurringCharge;
	
	@Column
	private String name;
	
	@Column
	private Float nonRecurringCharge;
}
