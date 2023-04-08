package com.saltbrook.datamodel.dto;

import javax.validation.constraints.NotNull;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BuildingDTO extends AssetDTO {
	
	private String vanityName;
	
	private Integer tenantCount;
	
	private Float totalArea;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	@NotNull
	private Point location;
	
	private String status;
	
	private String type;
	
	private String subType;
	
	private String сonstructionType;
	
}
