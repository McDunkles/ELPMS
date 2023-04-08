package com.saltbrook.datamodel.dto;

import java.util.HashMap;
import java.util.Map;

public class DTOFactory {
	
	private static final Map<String, DTOCreator<? extends BaseDTO>> dtos = new HashMap<>();
	
	static {
		dtos.put(CoreTypes.BUILDING, () -> { return new BuildingDTO(); });
		dtos.put(CoreTypes.ACCOUNT, () -> { return new AccountDTO(); });
		dtos.put(CoreTypes.RECURRING_EXPENSE, () -> { return new RecurringExpenseDTO(); });
		dtos.put(CoreTypes.RECURRING_REVENUE, () -> { return new RecurringRevenueDTO(); });
	}
	
	public static BaseDTO newInstance(String typeName) {
		return dtos.computeIfAbsent(typeName, (k) -> {
			return () -> { return null; };
		}).create();
	}
	
	@FunctionalInterface
	private interface DTOCreator<R> {
		
		R create();
		
	}
}
