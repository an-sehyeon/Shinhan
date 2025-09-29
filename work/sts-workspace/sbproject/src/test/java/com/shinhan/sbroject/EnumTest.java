package com.shinhan.sbroject;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.sbroject.entity.MemberRole;
import com.shinhan.sbroject.entity2.EnumTypeEntity;
import com.shinhan.sbroject.repository2.EnumTypeRepository;

@SpringBootTest
public class EnumTest {

		@Autowired
		EnumTypeRepository repo;
		
		@Test
		void f_insert() {
			Set<MemberRole> mroleSet = new HashSet<>();
			mroleSet.add(MemberRole.ADMIN);
			mroleSet.add(MemberRole.USER);
			mroleSet.add(MemberRole.MANAGER);
			EnumTypeEntity entity = EnumTypeEntity.builder(
					).mid("회원1").mname("홍길동")
					.mpassword("1234").mrole(mroleSet).build();
			repo.save(entity);
		}
}
