package com.saltbrook.datamodel.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class RecurringExpenseDTO extends StringIdDTO {
	
	@NotNull
	private String name;
	
	@PastOrPresent
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate createDate;
	
	@PastOrPresent
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate chargeMonth;
	
	@NotNull
	private Float amount;
	
	@NotNull
	private String expenseType;
	
	@NotNull
	private String assetId;
	
	@NotNull
	private String accountId;
	
	//TODO: consider extracting bandwidth to a separate type
	private Float bandwidth;

}
