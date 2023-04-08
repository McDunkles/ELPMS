package com.saltbrook.datamodel.mapper;

import java.util.HashMap;
import java.util.Map;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.dto.AccountDTO;
import com.saltbrook.datamodel.dto.BaseDTO;
import com.saltbrook.datamodel.dto.BuildingDTO;
import com.saltbrook.datamodel.dto.RecurringExpenseDTO;
import com.saltbrook.datamodel.dto.RecurringRevenueDTO;
import com.saltbrook.datamodel.persistence.BaseEntity;

public class MapperFactory {

	private static final Map<Class<? extends BaseDTO>, Class<? extends DtoEntityMapper<? extends BaseDTO, ? extends BaseEntity>>> mapperClasses = new HashMap<>();

	static {
		mapperClasses.put(BuildingDTO.class, BuildingMapper.class);
		mapperClasses.put(AccountDTO.class, AccountMapper.class);
		mapperClasses.put(RecurringExpenseDTO.class, RecurringExpenseMapper.class);
		mapperClasses.put(RecurringRevenueDTO.class, RecurringRevenueMapper.class);
	}

	public static DtoEntityMapper<? extends BaseDTO, ? extends BaseEntity> getInstance(
			Class<? extends BaseDTO> dtoClass) {
		Class<? extends DtoEntityMapper<? extends BaseDTO, ? extends BaseEntity>> mapperClass = mapperClasses.get(dtoClass);
		
		if (mapperClass != null) {
			return Mappers.getMapper(mapperClass);
		}
		
		return null;
	}

}
