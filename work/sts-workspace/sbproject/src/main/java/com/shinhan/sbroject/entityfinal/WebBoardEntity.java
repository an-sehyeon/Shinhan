package com.shinhan.sbroject.entityfinal;



import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shinhan.sbroject.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@ToString(exclude = {"replies"})
@Entity
@Table(name = "tbl_webboard")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebBoardEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bno;
	String title;
	String writer;
	String content;

	// fetch는 LAZY가 default
	/*
	 * @BatchSize(size = 100) 		
	 * 
	 * Board번호마다 댓글을 가져오기 위해 문장생성(N+1문제) : from tbl_webreply where board_bno=?
	 * 해결1) from tbl_webreply where board_bno in (?,?,?,?,?,?)
	 * 해결2) 함수 재정의하면서 fetch join	= (@EntityGraph이용)
	 * 해결3) 새로운 함수정의하면서 fetch join
	 * 
	 * */
	@JsonIgnore		// JSON생성시 무시된다.
	@OneToMany(
			mappedBy = "board", 
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	List<WebReplyEntity> replies;
}

















