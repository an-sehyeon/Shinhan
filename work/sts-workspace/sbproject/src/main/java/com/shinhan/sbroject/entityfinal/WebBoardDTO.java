package com.shinhan.sbroject.entityfinal;



import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebBoardDTO {
	
	Long bno;
	String title;
	String writer;
	String content;

	LocalDateTime regDate, modDate;
	List<WebReplyEntity> replyList;
	Long replyCount;
}
