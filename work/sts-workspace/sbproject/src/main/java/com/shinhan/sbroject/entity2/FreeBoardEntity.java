package com.shinhan.sbroject.entity2;

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
@ToString(exclude = "replies")
@Entity
@Table(name = "t_freeboard")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bno;
	String title;
	String writer;
	String content;
	
	// default는 fetch : LAZY임
	// Service level에서 @Transactional이라고 하면 Many가 로딩됨(EAGER)
	@JsonIgnore		// JSON으로 return시 replies제외
		// @ToString(exclude = "replies")와 비슷한 개념
	@OneToMany(
			mappedBy = "board",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	List<FreeReplyEntity> replies;
}



















