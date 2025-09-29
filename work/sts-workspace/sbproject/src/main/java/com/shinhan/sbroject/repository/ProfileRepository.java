package com.shinhan.sbroject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{
	
	// file이름으로 profile지우기
	@Modifying
	@Query("delete from ProfileEntity where fname=?1")
	int deleteByFname(String fname);
	
	// 1. @Query없이 기존함수를 재정의 함
	@EntityGraph(attributePaths = {"member"})		// 연관된 속성을 즉시 가져올지 명시, fetch join으로 생성되어 N+1 문제 해결
	List<ProfileEntity> findAll();
	
	// 2. fetch join이용
	@Query("select p from ProfileEntity p join fetch p.member")
	List<ProfileEntity> findAll2();
	
	// 규칙에 맞는 함수 정의
	List<ProfileEntity> findByCurrentYn(boolean currentYn);
	
	@EntityGraph(attributePaths = {"member"})	
	List<ProfileEntity> findByMemberAndCurrentYn(MemberEntity member,  boolean currentYn);
	
	//1)
	List<ProfileEntity> findByMember(MemberEntity member);
	List<ProfileEntity> findAllByMember(MemberEntity member);
	//2) 권장안함
	List<ProfileEntity> findAllByMemberMid(String mid);

	// JPQL 작성하기
	@Query(value = "select m.mid, count(p.fno)\r\n "
			+ "from t_profile p right outer JOIN t_member m on (p.member = m)\r\n"
			+ "group by m.mid\r\n"
			+ "order by m.mid", nativeQuery = true)
	List<Object[]> getMemberProfileCount();

	@Query(value = "select m.mid, count(p)\r\n "
			+ "from ProfileEntity p right outer JOIN MemberEntity m on (p.member = m)\r\n"
			+ "group by m.mid\r\n"
			+ "order by m.mid", nativeQuery = true)
	List<Object[]> getMemberProfileCount2();
}
