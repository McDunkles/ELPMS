package com.saltbrook.datamodel.gis.mapper;

import org.mapstruct.factory.Mappers;

import com.saltbrook.datamodel.gis.dto.BizDataLayerDTO;
import com.saltbrook.datamodel.gis.persistence.BizDataLayer;
import com.saltbrook.datamodel.mapper.BaseDtoMapperUnitTest;
import com.saltbrook.datamodel.mapper.EntityDtoMapper;

public class BizDataLayerDTOMapperUnitTest extends BaseDtoMapperUnitTest<BizDataLayer, BizDataLayerDTO> {

	@Override
	protected EntityDtoMapper<BizDataLayer, BizDataLayerDTO> getMapper() {
		return Mappers.getMapper(BizDataLayerDTOMapper.class);
	}

	@Override
	protected BizDataLayer getSourceEntity() {
		BizDataLayer entity = new BizDataLayer();
		entity.setId(123L);
		entity.setUrl("https://some.url");
		
		return entity;
	}

	@Override
	protected void assertTargetDTO(BizDataLayer entity, BizDataLayerDTO dto) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getUrl());
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getUrl(), dto.getUrl());
	}

}
