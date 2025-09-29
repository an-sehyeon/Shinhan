package com.shinhan.sbroject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.sbroject.entity2.UserCellPhoneEntity3;
import com.shinhan.sbroject.entity2.UserEntity3;
import com.shinhan.sbroject.repository2.UserRepository3;
import com.shinhan.sbroject.repository2.UsercellphoneRepository3;


@SpringBootTest
public class OneToOneTest {

	@Autowired
	UserRepository3 userRepo3;
	
	@Autowired
	UsercellphoneRepository3 phoneRepo3;
	
	// 주 = user, 부 = phone
	// 1. 주를 조회, 부를 가져오기
	// 2. 주를 삭제시, 부를 삭제
	// 3. 부만 삭제
	
	
	// 3. 부만 삭제	
	@Test
	void f_deletePhone() {
		phoneRepo3.deleteById("hh");
	}
	
	
	// 2. 주를 삭제시, 부를 삭제
//	@Test
	void f_delete() {
		userRepo3.deleteById("hh");
		
	}
	
	
	// 1. 주를 조회, 부를 가져오기
//	@Test
	void f_select() {
		userRepo3.findById("hh").ifPresentOrElse(user->{
			System.out.println("이름 : " + user.getUsername());
			System.out.println("전화번호 : " + user.getPhone().getPhoneNumber());
		}, ()->{
			System.out.println("존재하지않는 사용자입니다.");
		});
	}
	
	
//	@Test
	void f_insert3() {
		UserCellPhoneEntity3 phone = UserCellPhoneEntity3.builder()
				.phoneNumber("010-5555-5555")
				.model("아이폰19pro")
				.build();
		
		UserEntity3 user = UserEntity3.builder()
				.userid("hh").username("히히")
				.phone(phone)
				.build();
		phone.setUser3(user);

		userRepo3.save(user);
	}
	
//	@Test
//	void f_insert2() {
//		UserEntity2 user = UserEntity2.builder()
//				.userid("aa")
//				.username("안안")
//				.build();
//		UserCellPhoneEntity2 phone = UserCellPhoneEntity2.builder()
//				.phoneNumber("010-4444-4444")
//				.model("아이폰12pro")
//				.user(user)
//				.build();
//		userRepo2.save(phone);
//	}
	
//	@Test
//	void f_insert() {
//		
//		UserCellPhoneEntity phone = UserCellPhoneEntity.builder()
//				.phoneNumber("010-4444-4444")
//				.model("아이폰12pro")
//				.build();
////		phoneRepo.save(phone);
//		// user는 주테이블임, 부가 있어야 참조한다.
//		// @OneToOne(cascade = CascadeType.ALL)라면 연관 table도 insert됨
//		UserEntity user = UserEntity.builder()
//				.userid("aa")
//				.username("안안")
//				.phone(phone)
//				.build();
//		userRepo.save(user);
//	}
}
