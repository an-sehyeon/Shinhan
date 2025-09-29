package com.shinhan.sbroject.entity2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
@Table(name = "t_usercellphone3")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCellPhoneEntity3 {

	@Id	// 칼럼생성안함
	String dummyId;		
	
	// 대상 table에서 참조(식별자)
	// 칼럼생성됨
	@MapsId		// PK, FK
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	UserEntity3 user3;
	
	String phoneNumber;
	String model;
	
}
