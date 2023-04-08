package com.saltbrook.datamodel.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.TestingUtils;
import com.saltbrook.datamodel.dto.RecurringRevenueDTO;
import com.saltbrook.datamodel.persistence.RecurringRevenue;

public class RecurringRevenueMapperUnitTest extends BaseEntityMapperUnitTest<RecurringRevenueDTO, RecurringRevenue> {

	@Override
	protected DtoEntityMapper<RecurringRevenueDTO, RecurringRevenue> getMapper() {
		return Mappers.getMapper(RecurringRevenueMapper.class);
	}

	@Override
	protected RecurringRevenueDTO getSourceDTO() {
		RecurringRevenueDTO dto = new RecurringRevenueDTO();
		dto.setName("name01");
		dto.setId("aaa7878");
		dto.setCreateDate(TestingUtils.parseDate("08/15/2020"));
		dto.setChargeMonth(TestingUtils.parseDate("08/01/2020"));
		
		return dto;
	}

	@Override
	protected void assertTargetEntity(RecurringRevenueDTO dto, RecurringRevenue entity) {
		assertNotNull(dto.getName());
		assertNotNull(dto.getId());
		assertNotNull(dto.getCreateDate());
		assertNotNull(dto.getChargeMonth());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getCreateDate(), entity.getCreateDate());
		assertEquals(dto.getChargeMonth(), entity.getChargeMonth());
		assertNull(entity.getAmount());
	}

}
