package com.saltbrook.datamodel.dto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.saltbrook.datamodel.BaseUnitTestCase;

public class DTOClassesUnitTest extends BaseUnitTestCase {

	@Test
	public void validTypesAreResolved() {
		assertEquals(BuildingDTO.class, DTOClasses.byTypeName(CoreTypes.BUILDING));
		assertEquals(AccountDTO.class, DTOClasses.byTypeName(CoreTypes.ACCOUNT));
		assertEquals(RecurringExpenseDTO.class, DTOClasses.byTypeName(CoreTypes.RECURRING_EXPENSE));
		assertEquals(RecurringRevenueDTO.class, DTOClasses.byTypeName(CoreTypes.RECURRING_REVENUE));
	}

	@Test
	public void invalidTypeIsResolvedToNull() {
		assertNull(DTOClasses.byTypeName("some/invalidType"));
	}

	@Test
	public void allValidTypesAreListed() {
		List<String> expectedTypes = Arrays.asList(CoreTypes.BUILDING, CoreTypes.ACCOUNT, CoreTypes.RECURRING_EXPENSE,
				CoreTypes.RECURRING_REVENUE);
		List<String> actualTypes = DTOClasses.validTypeNames();

		assertEquals(expectedTypes.size(), actualTypes.size());
		assertTrue(expectedTypes.containsAll(actualTypes));
	}
}
