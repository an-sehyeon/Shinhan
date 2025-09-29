package com.shinhan.sbroject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@AllArgsConstructor
@Data
public class CarDTO {
	
	@NonNull
	int carId;
	String model;
	int price;
}
