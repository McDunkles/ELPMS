package com.saltbrook.datamodel.gis.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.gis.dto.BuildingHeightLayerDTO;
import com.saltbrook.datamodel.gis.persistence.BuildingHeightLayer;
import com.saltbrook.datamodel.mapper.BaseDtoMapperUnitTest;
import com.saltbrook.datamodel.mapper.EntityDtoMapper;

public class BuildingHeightLayerDTOMapperUnitTest extends BaseDtoMapperUnitTest<BuildingHeightLayer, BuildingHeightLayerDTO> {

	@Override
	protected EntityDtoMapper<BuildingHeightLayer, BuildingHeightLayerDTO> getMapper() {
		return Mappers.getMapper(BuildingHeightLayerDTOMapper.class);
	}

	@Override
	protected BuildingHeightLayer getSourceEntity() {
		BuildingHeightLayer entity = new BuildingHeightLayer();
		entity.setId(123L);
		entity.setUrl("https://some.url");
		
		return entity;
	}

	@Override
	protected void assertTargetDTO(BuildingHeightLayer entity, BuildingHeightLayerDTO dto) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getUrl());
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getUrl(), dto.getUrl());
	}

}
