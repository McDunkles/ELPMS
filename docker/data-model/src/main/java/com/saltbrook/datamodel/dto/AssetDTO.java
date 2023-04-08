package com.saltbrook.datamodel.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AssetDTO extends StringIdDTO {
	
	@NotNull
	private String name;
	
	private String comments;
	
	private String ownerId;
	
}
