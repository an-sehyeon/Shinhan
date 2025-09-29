package com.shinhan.sbroject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.sbroject.dto.CarDTO;

@SpringBootTest
class SbprojectApplicationTests {

	@Test
	void f1() {
		CarDTO car1 = new CarDTO(1, "차1", 1000);
		CarDTO car2 = new CarDTO(2, "차2", 2000);
		CarDTO car3 = CarDTO.builder()
				.carId(3)
				.model("차2")
				.price(3000)
				.build();
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
	}
	
	@Test
	void contextLoads() {
	}

}
