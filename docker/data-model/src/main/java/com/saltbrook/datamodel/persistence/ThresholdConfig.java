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

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Access(AccessType.FIELD)
@Table(name = "THRESHOLD_CONFIG")
public class ThresholdConfig {
	
	@Id
	@Column
	private Integer id;
	
	@Column(nullable = false)
	private String metric;
	
	@Column
	private Float red;
	
	@Column
	private Float yellow;
	
	@Column
	private Float green;
	
	@Column
	private String redRanges;
	
	@Column
	private String yellowRanges;
	
	@Column
	private String greenRanges;
	
	@Column
	private Boolean reverse;
	
}
