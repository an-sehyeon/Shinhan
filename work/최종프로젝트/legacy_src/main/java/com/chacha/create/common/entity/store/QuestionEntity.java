package com.chacha.create.common.entity.store;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 상품 문의 정보를 나타내는 엔티티 클래스
 * <p>
 * DB의 {@code question} 테이블과 매핑되며,
 * 회원이 작성한 상품 문의 데이터를 포함합니다.
 * </p>
 *
 * <pre>
 * 필드 설명:
 * - questionId     : 문의글 고유 ID (기본 키)
 * - memberId       : 작성한 회원 ID (외래키)
 * - questionDate   : 문의 작성 일자
 * - questionTitle  : 문의 제목
 * - questionText   : 문의 본문 내용 (DB에서는 CLOB 타입으로 저장됨)
 * </pre>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {

    /** 문의글 고유 ID */
    private Integer questionId;

    /** 작성자 회원의 ID */
    private Integer memberId;

    /** 문의 작성 일자 */
    private Date questionDate;

    /** 문의 제목 */
    private String questionTitle;

    /** 문의 본문 내용 (DB에서는 CLOB 타입으로 저장됨) */
    private String questionText;
}
