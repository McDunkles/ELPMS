package com.saltbrook.datamodel.dto;

import org.junit.jupiter.api.Test;

import com.saltbrook.datamodel.BaseUnitTestCase;

public class DTOFactoryUnitTest extends BaseUnitTestCase {
	
	@Test
	public void buildingDtoIsInstantiated() {
		assertDtoIsInstantiated(CoreTypes.BUILDING, BuildingDTO.class);
	}
	
	@Test
	public void accountDtoIsInstantiated() {
		assertDtoIsInstantiated(CoreTypes.ACCOUNT, AccountDTO.class);
	}
	
	@Test
	public void recurringExpenseDtoIsInstantiated() {
		assertDtoIsInstantiated(CoreTypes.RECURRING_EXPENSE, RecurringExpenseDTO.class);
	}
	
	@Test
	public void recurringRevenueDtoIsInstantiated() {
		assertDtoIsInstantiated(CoreTypes.RECURRING_REVENUE, RecurringRevenueDTO.class);
	}
	
	@Test
	public void nullIsReturnedForNonExistingType() {
		assertNull(DTOFactory.newInstance("nonExstingType"));
	}
	
	private void assertDtoIsInstantiated(String typeName, Class<? extends BaseDTO> typeClass) {
		BaseDTO dto = DTOFactory.newInstance(typeName);
		assertSame(typeClass, dto.getClass());
		
		// Verify that new instance is created each time
		BaseDTO nextDto = DTOFactory.newInstance(typeName);
		assertNotSame(dto, nextDto);
	}
	
}
