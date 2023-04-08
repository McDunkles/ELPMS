package com.saltbrook.datamodel.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.dto.RecurringExpenseDTO;
import com.saltbrook.datamodel.persistence.RecurringExpenseV2;

@Mapper
public interface RecurringExpenseMapper extends DtoEntityMapper<RecurringExpenseDTO, RecurringExpenseV2> {
	
}
