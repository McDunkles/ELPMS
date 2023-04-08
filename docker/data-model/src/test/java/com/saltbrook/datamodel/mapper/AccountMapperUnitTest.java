package com.saltbrook.datamodel.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.dto.AccountDTO;
import com.saltbrook.datamodel.persistence.AccountV2;

public class AccountMapperUnitTest extends BaseEntityMapperUnitTest<AccountDTO, AccountV2> {

	@Override
	protected DtoEntityMapper<AccountDTO, AccountV2> getMapper() {
		return Mappers.getMapper(AccountMapper.class);
	}

	@Override
	protected AccountDTO getSourceDTO() {
		AccountDTO dto = new AccountDTO();
		dto.setName("name01");
		dto.setId("aa01");
		dto.setType("Receivable");
		dto.setSubType("Subscriber");
		
		return dto;
	}

	@Override
	protected void assertTargetEntity(AccountDTO dto, AccountV2 entity) {
		assertNotNull(dto.getName());
		assertNotNull(dto.getId());
		assertNotNull(dto.getType());
		assertNotNull(dto.getSubType());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getType(), entity.getType());
		assertEquals(dto.getSubType(), entity.getSubType());
		assertNull(entity.getBillingAddress());
	}
	
	
}
