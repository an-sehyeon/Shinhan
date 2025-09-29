package com.shinhan.sbroject.entity2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "t_usercellphone1")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCellPhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	Long phoneId;
	String phoneNumber;
	String model;
}
