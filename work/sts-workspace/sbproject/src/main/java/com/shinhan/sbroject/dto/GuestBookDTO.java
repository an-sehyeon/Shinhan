package com.shinhan.sbroject.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestBookDTO {

	Long gno;
	String title;
	String writer;
	String content;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	String description;
}
