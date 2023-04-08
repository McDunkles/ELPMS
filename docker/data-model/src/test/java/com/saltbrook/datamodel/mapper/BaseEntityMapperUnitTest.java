package com.saltbrook.datamodel.mapper;

import org.junit.jupiter.api.Test;

import com.saltbrook.datamodel.BaseUnitTestCase;
import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public abstract class BaseEntityMapperUnitTest<D extends BaseDTO, E extends BaseEntity> extends BaseUnitTestCase {
	
	protected abstract DtoEntityMapper<D, E> getMapper();
	
	protected abstract D getSourceDTO();
	
	protected abstract void assertTargetEntity(D dto, E entity);
	
	@Test
	public void dtoCanBeMappedToEntity() {
		D dto = getSourceDTO();
		E entity = getMapper().dtoToEntity(dto);
		assertTargetEntity(dto, entity);
	}

}
