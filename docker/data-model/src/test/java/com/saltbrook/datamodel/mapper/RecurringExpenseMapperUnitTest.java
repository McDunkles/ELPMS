package com.saltbrook.datamodel.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.TestingUtils;
import com.saltbrook.datamodel.dto.RecurringExpenseDTO;
import com.saltbrook.datamodel.persistence.RecurringExpenseV2;

public class RecurringExpenseMapperUnitTest extends BaseEntityMapperUnitTest<RecurringExpenseDTO, RecurringExpenseV2> {

	@Override
	protected DtoEntityMapper<RecurringExpenseDTO, RecurringExpenseV2> getMapper() {
		return Mappers.getMapper(RecurringExpenseMapper.class);
	}

	@Override
	protected RecurringExpenseDTO getSourceDTO() {
		RecurringExpenseDTO dto = new RecurringExpenseDTO();
		dto.setName("name01");
		dto.setId("aaa7878");
		dto.setCreateDate(TestingUtils.parseDate("08/15/2020"));
		dto.setChargeMonth(TestingUtils.parseDate("08/01/2020"));
		dto.setBandwidth(1000.0f);
		
		return dto;
	}

	@Override
	protected void assertTargetEntity(RecurringExpenseDTO dto, RecurringExpenseV2 entity) {
		assertNotNull(dto.getName());
		assertNotNull(dto.getId());
		assertNotNull(dto.getCreateDate());
		assertNotNull(dto.getChargeMonth());
		assertNotNull(dto.getBandwidth());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getCreateDate(), entity.getCreateDate());
		assertEquals(dto.getChargeMonth(), entity.getChargeMonth());
		assertEquals(dto.getBandwidth(), entity.getBandwidth());
		assertNull(entity.getAmount());
	}

}
