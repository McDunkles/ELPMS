package com.saltbrook.datamodel.persistence;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "MARKETING")
public class Marketing {
	
	@Id
	@Column
	private Integer id;
	
	//TODO: Consider Building entity as a relationship owner,
	// as a marketing query is performed multiple times, per each selected building
	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.JOIN)
	@JoinColumn(name = "building_id")
	private Building building;
	
	@Column
	private Float penetrationPlanned;
	
	@Column
	private Float penetrationActual;
	
	@Column
	private Integer cancelledCustomers;

}
