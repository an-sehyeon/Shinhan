package com.shinhan.sbroject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 1명의 member 여러 profile를 갖는다.
// 프로필은 여러개, 여러개의 profile이 한 멤버의 것이다.
@Getter @Setter 
//@ToString(exclude = {"member"})
@ToString
@Entity
@Table(name = "t_profile")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long fno;
	String fname;
	boolean currentYn;
	
	// JAP가 아닌경우 사용 : String mid
	// **연관관게 추가함**
	// @ManyToOne fetch의 default는 EAGER(즉시로딩)  
	@ManyToOne(fetch = FetchType.EAGER)
//	@ManyToOne(fetch = FetchType.LAZY)		// 지연로딩... toString()에 반드시 exclude추가
	MemberEntity member;		// DB에 칼람이름은 member_mid
}
