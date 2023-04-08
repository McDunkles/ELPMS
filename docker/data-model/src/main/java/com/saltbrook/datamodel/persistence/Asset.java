package com.saltbrook.datamodel.persistence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Asset extends BaseEntity {
	
	@Id
	@Column
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String comments;
	
	//TODO: create DTO layer and move JSON config there
	@Column
	@JsonProperty("propertyOwner")
	private String ownerId;
	
}
