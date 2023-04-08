package com.saltbrook.datamodel.mapper;

import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public interface DtoEntityMapper<D extends BaseDTO, E extends BaseEntity> {
	
	E dtoToEntity(D dto);
	
}
