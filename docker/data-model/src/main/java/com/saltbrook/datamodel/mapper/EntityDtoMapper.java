package com.saltbrook.datamodel.mapper;

import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public interface EntityDtoMapper<E extends BaseEntity, D extends BaseDTO> {
	
	D entityToDto(E entity);
	
}
