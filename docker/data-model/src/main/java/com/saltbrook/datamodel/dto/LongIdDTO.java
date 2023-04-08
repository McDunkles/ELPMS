package com.saltbrook.datamodel.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class LongIdDTO extends BaseDTO {
	
	@NotNull
	private Long id;
	
}
