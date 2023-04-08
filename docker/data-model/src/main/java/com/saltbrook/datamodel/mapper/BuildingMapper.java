package com.saltbrook.datamodel.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.dto.BuildingDTO;
import com.saltbrook.datamodel.persistence.Building;

@Mapper
public interface BuildingMapper extends DtoEntityMapper<BuildingDTO, Building> {
	
}
