package com.shinhan.sbroject.entity2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter 
@ToString
@Entity
@Table(name = "t_user1")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "user_id")
	String userid;
	@Column(name = "user_name")
	String username;
	
	// 1. 주테이블에서 참조하기
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")	// 주테이블에 칼럼 생성
	UserCellPhoneEntity phone;
}
