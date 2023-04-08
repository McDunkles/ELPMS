package com.saltbrook.datamodel.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.dto.AccountDTO;
import com.saltbrook.datamodel.persistence.AccountV2;


//@Mapper(componentModel = "spring")
@Mapper
public interface AccountMapper extends DtoEntityMapper<AccountDTO, AccountV2> {
	
}
