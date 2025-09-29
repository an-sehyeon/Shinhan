package com.shinhan.sbroject;


import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.entity.MemberRole;
import com.shinhan.sbroject.entity.ProfileEntity;
import com.shinhan.sbroject.repository.MemberRepository;
import com.shinhan.sbroject.repository.ProfileRepository;

@SpringBootTest
public class ManyToOneTest {
	
	@Autowired
	MemberRepository memberRepo;
	@Autowired
	ProfileRepository profileRepo;
	
	
//	[LAB] 특정Member의 currentYn값으로 Profile를 select하기
//	@Test
	void f_member_currentYn() {
		boolean currentYn = true;
		MemberEntity member = MemberEntity.builder().mid("회원3").build();
		profileRepo.findByMemberAndCurrentYn(member, currentYn).forEach(cur->{
			System.out.println(cur);
		});
	}
	
	
	
	// [LAB] currentYn값으로 Profile를 select하기
//	@Test
	void f_currentYn() {
		boolean currentYn = true;
		profileRepo.findByCurrentYn(currentYn).forEach(cur->{
			System.out.println(cur);
		});
	}
	
	
	// Member가 가지는 Profile의 개수를 알아내기
	// 회원3 = 7개
	// 회원6 = 7개
	// 회원2 = 4개
//	@Test
	void f_getMemberProfileCount2() {
	    profileRepo.getMemberProfileCount().forEach(arr -> {
	        System.out.println(Arrays.toString(arr)); 
	    });
	}

	
	
//	@Test
	void f_selectById() {
		String mid = "회원6";
		MemberEntity member = MemberEntity.builder().mid(mid).build();
		profileRepo.findByMember(member).forEach(pro->{System.out.println(pro);});;
//		profileRepo.findAllByMember(member).forEach(pro->{System.out.println(pro);});;
	}
	
//	@Test
	void f_selectAll2() {
		profileRepo.findAll2().forEach(frofile->{
			System.out.println(frofile);
			System.out.println(frofile.getMember());
		});
	}
	
	
	
//	@Test
	void f_selectAll() {
		profileRepo.findAll().forEach(frofile->{
			System.out.println(frofile);
			System.out.println(frofile.getMember());
		});
	}
	
	// Profile등록.. 하나의 Member가 7개의 Profile을 갖는다.
//	@Test
	void f_profileInsert() {
		MemberEntity member = memberRepo.findById("회원2").get();
		if(member == null) {
			System.out.println("존재하지않는 member");
			return;
		}
		IntStream.rangeClosed(1, 4).forEach(i->{
			ProfileEntity profile = ProfileEntity.builder()
					.fname("flower"+i+".jpg")
					.currentYn(i==3?true:false)
					.member(member)
					.build();
			profileRepo.save(profile);
		});
	}
	
//	@Test
	void f_memberAll() {
		memberRepo.findAll().forEach(member->{
			System.out.println(member);
		});
	}
	
//	@Test
	void f_memberUpdate() {
		memberRepo.findById("회원5").ifPresent(member->{
			member.setMrole(MemberRole.ADMIN);
			memberRepo.save(member);
		});
	}
	
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Test
	void f_memberInsert() {
		String[] arr = {"바다", "지민","윤정","민혁","민성","희찬"};
		IntStream.rangeClosed(0, 5).forEach(i->{
			MemberEntity member = MemberEntity.builder()
					.mid("회원" + i )
					.mname(arr[i])
					.mpassword(passEncoder.encode("1234"))
					.mrole(i%2==0?MemberRole.MANAGER:MemberRole.USER)
					.build();
			if(i==5) member.setMrole(MemberRole.ADMIN);
			memberRepo.save(member);
		});
	}
	

	
//	@Test
	void f_memberpassUpdate() {
		IntStream.rangeClosed(1, 6).forEach(i->{
			memberRepo.findById("회원"+i).ifPresent(member->{
					member.setMpassword(passEncoder.encode("1234"));
					memberRepo.save(member);
			}); 
		});
	}

}
