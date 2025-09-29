package com.shinhan.sbroject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.sbroject.entity2.MultiKeyAEntity;
import com.shinhan.sbroject.entity2.MultiKeyB;
import com.shinhan.sbroject.entity2.MultiKeyBEntity;
import com.shinhan.sbroject.repository2.MultiKeyARepository;
import com.shinhan.sbroject.repository2.MultiKeyBRepository;

@SpringBootTest
public class MultiKeyTest {
	
	@Autowired
	MultiKeyARepository aRepo;
	
	@Autowired
	MultiKeyBRepository bRepo;
	
	@Test
	void f_insertB() {
		MultiKeyB newid1 = MultiKeyB.builder().id1(1).id2(1).build();
		MultiKeyB newid2 = MultiKeyB.builder().id1(2).id2(2).build();

		MultiKeyBEntity obj1 = MultiKeyBEntity.builder().id(newid1).name("멀티키1-1").build();
		MultiKeyBEntity obj2 = MultiKeyBEntity.builder().id(newid2).name("멀티키1-2").build();
		bRepo.save(obj1);
		bRepo.save(obj2);
	}
	
//	@Test
	void f_insertA() {
		MultiKeyAEntity obj1 = MultiKeyAEntity.builder().id1(1).id2(1).name("멀티키1-1").build();
		MultiKeyAEntity obj2 = MultiKeyAEntity.builder().id1(2).id2(2).name("멀티키1-2").build();
		aRepo.save(obj1);
		aRepo.save(obj2);
	}

}
