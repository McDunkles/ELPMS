package com.saltbrook.datamodel.mapper;

import org.mapstruct.Mapper;

import com.saltbrook.datamodel.dto.RecurringRevenueDTO;
import com.saltbrook.datamodel.persistence.RecurringRevenue;

@Mapper
public interface RecurringRevenueMapper extends DtoEntityMapper<RecurringRevenueDTO, RecurringRevenue> {

}
