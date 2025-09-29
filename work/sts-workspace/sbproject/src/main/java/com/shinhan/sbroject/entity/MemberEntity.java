package com.shinhan.sbroject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 1명의 member
@Getter @Setter 
@ToString
@Entity
@Table(name = "t_member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
	
	@Id
	String mid;
	String mpassword;
	String mname;
	
	@Enumerated(EnumType.STRING)
	MemberRole mrole;
}
