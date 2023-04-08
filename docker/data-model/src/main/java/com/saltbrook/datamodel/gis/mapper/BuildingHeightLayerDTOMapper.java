package com.saltbrook.datamodel.gis.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.gis.dto.BuildingHeightLayerDTO;
import com.saltbrook.datamodel.gis.persistence.BuildingHeightLayer;
import com.saltbrook.datamodel.mapper.EntityDtoMapper;


@Mapper
public interface BuildingHeightLayerDTOMapper extends EntityDtoMapper<BuildingHeightLayer, BuildingHeightLayerDTO> {
	
}
