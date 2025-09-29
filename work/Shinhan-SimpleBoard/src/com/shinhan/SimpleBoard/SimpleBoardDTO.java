package com.shinhan.SimpleBoard;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleBoardDTO {
	 private int bno;
	 private String writer;
	 private Date writedate;
	 private String title;
	 private String contents;
}
