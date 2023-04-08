package com.saltbrook.datamodel.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.TestingUtils;
import com.saltbrook.datamodel.dto.BuildingDTO;
import com.saltbrook.datamodel.persistence.Building;

public class BuildingMapperUnitTest extends BaseEntityMapperUnitTest<BuildingDTO, Building> {

	@Override
	protected DtoEntityMapper<BuildingDTO, Building> getMapper() {
		return Mappers.getMapper(BuildingMapper.class);
	}

	@Override
	protected BuildingDTO getSourceDTO() {
		BuildingDTO dto = new BuildingDTO();
		dto.setName("name01");
		dto.setId("aa01");
		dto.setLocation(TestingUtils.createPoint(20.0, 50.0));
		
		return dto;
	}

	@Override
	protected void assertTargetEntity(BuildingDTO dto, Building entity) {
		assertNotNull(dto.getName());
		assertNotNull(dto.getId());
		assertNotNull(dto.getLocation());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getLocation(), entity.getLocation());
		assertNull(entity.getCity());
	}
	
	
}
