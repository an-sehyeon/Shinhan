package com.shinhan.sbroject.entity2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "t_usercellphone2")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCellPhoneEntity2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	Long phoneId;
	String phoneNumber;
	String model;
	
	// 2.대상테이블에서 참조(비식별자)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	UserEntity2 user;
}
