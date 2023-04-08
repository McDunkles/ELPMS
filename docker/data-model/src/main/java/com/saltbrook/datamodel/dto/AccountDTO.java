package com.saltbrook.datamodel.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO extends StringIdDTO {
	
	@NotNull
	private String name;
	
	private String type;
	
	private String subType;
	
	private String comments;
	
	private String billingAddress;
	
	private String billingCity;
	
	private String billingState;
	
	private String billingPostalCode;
	
	private String billingCountry;
	
}
