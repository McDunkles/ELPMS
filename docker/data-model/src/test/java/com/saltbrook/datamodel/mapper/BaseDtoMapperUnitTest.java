package com.saltbrook.datamodel.mapper;

import org.junit.jupiter.api.Test;

import com.saltbrook.datamodel.BaseUnitTestCase;
import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public abstract class BaseDtoMapperUnitTest<E extends BaseEntity, D extends BaseDTO> extends BaseUnitTestCase {
	
	protected abstract EntityDtoMapper<E, D> getMapper();
	
	protected abstract E getSourceEntity();
	
	protected abstract void assertTargetDTO(E entity, D dto);
	
	@Test
	public void entityCanBeMappedToDto() {
		E entity = getSourceEntity();
		D dto = getMapper().entityToDto(entity);
		assertTargetDTO(entity, dto);
	}

}
