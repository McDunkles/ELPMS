package com.saltbrook.datamodel.gis.dto;

import javax.validation.constraints.NotNull;

import com.saltbrook.datamodel.dto.LongIdDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizDataLayerDTO extends LongIdDTO {
	
	@NotNull
	private String url;

}
