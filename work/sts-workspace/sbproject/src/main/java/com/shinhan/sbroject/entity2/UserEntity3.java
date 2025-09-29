package com.shinhan.sbroject.entity2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "t_user3")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity3 {

	@Id
	@Column(name = "user_id")
	String userid;
	@Column(name = "user_name")
	String username;
	
	// 주 table에서 참조
	// mappedBy는 실제칼럼생성안됨, 메어있음
	@OneToOne(
			mappedBy = "user3",
			cascade = CascadeType.ALL)
	UserCellPhoneEntity3 phone;
}
