package com.chacha.create.common.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원의 결제 카드 정보를 나타내는 엔티티 클래스입니다.
 * <p>
 * DB의 {@code card} 테이블과 매핑되며,
 * 회원이 등록한 여러 카드 정보를 저장합니다.
 * </p>
 *
 * <pre>
 * 예시:
 * cardId: 101
 * memberId: 5
 * cardNum: "1234-5678-9012-3456"
 * cardCompany: "Visa"
 * cardToken: "tokenized_card_info"
 * cardAlias: "주카드"
 * </pre>
 * 
 * 카드 번호는 보안을 위해 토큰화하여 저장하며, 실제 카드번호 저장은 지양합니다.
 * </p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {

    /**
     * 카드 고유 ID (기본 키)
     */
    private Integer cardId;

    /**
     * 카드 소유 회원 ID (외래키)
     */
    private Integer memberId;

    /**
     * 카드 번호 (토큰화 이전 원본 번호는 저장하지 않는 것이 권장됨)
     */
    private String cardNum;

    /**
     * 카드사명 (예: Visa, MasterCard, Amex 등)
     */
    private String cardCompany;

    /**
     * 카드 번호 토큰 (결제 연동 시 사용)
     */
    private String cardToken;

    /**
     * 카드 별칭 (사용자가 설정한 카드 이름)
     */
    private String cardAlias;
}
