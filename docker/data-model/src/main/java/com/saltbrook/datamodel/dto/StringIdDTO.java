package com.saltbrook.datamodel.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class StringIdDTO extends BaseDTO {
	
	@NotNull
	private String id;
	
}
