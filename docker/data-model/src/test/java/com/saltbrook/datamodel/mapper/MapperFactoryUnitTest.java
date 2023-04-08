package com.saltbrook.datamodel.mapper;

import org.junit.jupiter.api.Test;

import com.saltbrook.datamodel.BaseUnitTestCase;
import com.saltbrook.datamodel.dto.AccountDTO;
import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.dto.BuildingDTO;
import com.saltbrook.datamodel.dto.RecurringExpenseDTO;
import com.saltbrook.datamodel.dto.RecurringRevenueDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public class MapperFactoryUnitTest extends BaseUnitTestCase {

	@Test
	public void buildingMapperIsInstantiated() {
		assertMapperFor(BuildingMapper.class, BuildingDTO.class);
	}
	
	@Test
	public void accountMapperIsInstantiated() {
		assertMapperFor(AccountMapper.class, AccountDTO.class);
	}
	
	@Test
	public void recurringExpenseMapperIsInstantiated() {
		assertMapperFor(RecurringExpenseMapper.class, RecurringExpenseDTO.class);
	}
	
	@Test
	public void recurringRevenueMapperIsInstantiated() {
		assertMapperFor(RecurringRevenueMapper.class, RecurringRevenueDTO.class);
	}
	
	@Test
	public void nullIsReturnedForImproperDTO() {
		assertNull(MapperFactory.getInstance(ImproperDTO.class));
	}

	private void assertMapperFor(Class<? extends DtoEntityMapper<? extends BaseDTO, ? extends BaseEntity>> mapperClass,
			Class<? extends BaseDTO> dtoClass) {
		assertTrue(mapperClass.isAssignableFrom(MapperFactory.getInstance(dtoClass).getClass()));
	}
	
	private static class ImproperDTO extends BaseDTO {
		
	}

}