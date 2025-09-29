package com.chacha.create.common.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원의 장바구니(Cart) 정보를 나타내는 엔티티 클래스입니다.
 * <p>
 * DB의 {@code cart} 테이블과 매핑되며,
 * 회원이 장바구니에 담은 상품과 수량 정보를 저장합니다.
 * </p>
 *
 * <pre>
 * 예시:
 * cartId: 1001
 * memberId: 5
 * productId: 2002
 * productCnt: 3
 * </pre>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    /**
     * 장바구니 항목 고유 ID (기본 키)
     */
    private Integer cartId;

    /**
     * 장바구니 소유 회원 ID (외래키)
     */
    private Integer memberId;

    /**
     * 장바구니에 담긴 상품 ID (외래키)
     */
    private Integer productId;

    /**
     * 해당 상품의 수량
     */
    private Integer productCnt;
}
