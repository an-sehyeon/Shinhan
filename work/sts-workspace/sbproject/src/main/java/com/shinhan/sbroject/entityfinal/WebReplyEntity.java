package com.shinhan.sbroject.entityfinal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shinhan.sbroject.entity.BaseEntity;

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


@Entity
@Table(name = "tbl_webreply")
@Builder
@Getter @Setter 
@ToString(exclude = {"board"})
@NoArgsConstructor
@AllArgsConstructor
public class WebReplyEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long rno;
	String replyText;
	String replyer;

	// fetch는 EAGER가 default
	@JsonIgnore		// JSON 생성시 무시된다.
	@ManyToOne(fetch = FetchType.LAZY)
	WebBoardEntity board;
}






















