package com.shinhan.model.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {
	private int bno;    
	private String title;  
	private String content;
	private String writer; 
	private String pic1;   
	private String pic2;   
}
