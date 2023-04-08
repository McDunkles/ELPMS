package com.saltbrook.datamodel.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DTOClasses {

	private static final Map<String, Class<? extends BaseDTO>> dtoClasses = new LinkedHashMap<>();

	private static final List<String> allTypeNames;

	static {
		dtoClasses.put(CoreTypes.BUILDING, BuildingDTO.class);
		dtoClasses.put(CoreTypes.ACCOUNT, AccountDTO.class);
		dtoClasses.put(CoreTypes.RECURRING_EXPENSE, RecurringExpenseDTO.class);
		dtoClasses.put(CoreTypes.RECURRING_REVENUE, RecurringRevenueDTO.class);

		allTypeNames = dtoClasses.keySet().stream().collect(Collectors.toUnmodifiableList());
	}

	public static Class<? extends BaseDTO> byTypeName(String typeName) {
		return dtoClasses.get(typeName);
	}

	public static List<String> validTypeNames() {
		return allTypeNames;
	}

}
