package com.shinhan.sbroject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.sbroject.dto.CarDTO;

@RestController
public class SampleController {
	
	@GetMapping("/sample1")
	public String sample1() {
		return "hihi";
	}
	@GetMapping("/car1")
	public CarDTO car() {
			CarDTO car1 = new CarDTO(1, "차1", 1000);
			CarDTO car2 = new CarDTO(2, "차2", 2000);
			CarDTO car3 = CarDTO.builder()
					.carId(3)
					.model("차2")
					.price(3000)
					.build();
			return car1;
	}
	
	@GetMapping("/car2")
	public List<CarDTO> car2() {
		List<CarDTO> carlist = new ArrayList<>();
		CarDTO car1 = new CarDTO(1, "차1", 1000);
		CarDTO car2 = new CarDTO(2, "차2", 2000);
		CarDTO car3 = CarDTO.builder()
				.carId(3)
				.model("차2")
				.price(3000)
				.build();
		carlist.add(car1);
		carlist.add(car2);
		carlist.add(car3);
		return carlist;
	}
}

