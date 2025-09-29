package com.shinhan.sbroject.entityfinal;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter 
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebReplyDTO {
	
	Long rno;
	String replyText;
	String replyer;
	LocalDateTime regDate;
	LocalDateTime modDate;
	Long bno;

}
