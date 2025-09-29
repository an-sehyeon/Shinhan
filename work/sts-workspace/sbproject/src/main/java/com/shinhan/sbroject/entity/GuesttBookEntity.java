package com.shinhan.sbroject.entity;

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

@Entity
@Table(name = "t_guestbook")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuesttBookEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long gno;
	String title;
	String writer;
	String content;
	
	@Override
	public String toString() {
		return "GuesttBookEntity [gno=" + gno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
