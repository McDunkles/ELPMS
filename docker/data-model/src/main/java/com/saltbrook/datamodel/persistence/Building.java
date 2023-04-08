package com.saltbrook.datamodel.persistence;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

//TODO: move JSON related annotations to DTO layer
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
@Table(name = "BUILDING_V2")
public class Building extends Asset {
	
	@Column
	private String vanityName;
	
	@Column
	private Integer tenantCount;
	
	@Column
	private Float totalArea;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String postalCode;
	
	@Column
	private Point location;
	
	@Column
	private String status;
	
	@Column
	private String type;
	
	@Column
	private String subType;
	
	@Column
	private String сonstructionType;
	
	@OneToOne(mappedBy = "building", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.JOIN)
    private Revenue revenue;
	
	@OneToOne(mappedBy = "building", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.JOIN)
    private Marketing marketing;
	
	
	@OneToOne(mappedBy = "building", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.JOIN)
    private Utilization utilization;
	
}
