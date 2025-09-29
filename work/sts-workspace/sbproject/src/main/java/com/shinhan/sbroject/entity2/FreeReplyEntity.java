package com.shinhan.sbroject.entity2;


import com.shinhan.sbroject.entity.BaseEntity;

import jakarta.persistence.Entity;
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


@Getter @Setter 
@ToString
@Entity
@Table(name = "t_feereply")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreeReplyEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long rno;
	String reply;
	String replyer;
	
	
	// default는 fetch : EAGER임
	@ManyToOne
	FreeBoardEntity board;		// 칼럼이름은 board_bno
	
	
}
















