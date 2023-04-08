package com.saltbrook.datamodel.gis.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.gis.dto.BizDataLayerDTO;
import com.saltbrook.datamodel.gis.persistence.BizDataLayer;
import com.saltbrook.datamodel.mapper.EntityDtoMapper;


@Mapper
public interface BizDataLayerDTOMapper extends EntityDtoMapper<BizDataLayer, BizDataLayerDTO> {
	
}
