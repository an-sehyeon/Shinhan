package com.chacha.create.common.entity.order;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 배송 정보를 나타내는 엔티티 클래스입니다.
 * <p>
 * DB의 {@code delivery} 테이블과 매핑되며,
 * 주문의 배송 상태 및 관련 날짜 정보를 관리합니다.
 * </p>
 *
 * <pre>
 * 필드 설명:
 * deliveryId    : 배송 고유 ID (기본 키)
 * orderId       : 관련 주문 ID (외래키)
 * deliveryCheck : 배송 상태 (0: 미배송, 1: 배송완료)
 * deliveryDate  : 배송 시작일자
 * deliveryFinDate : 배송 완료일자
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryEntity {
    
    /**
     * 배송 고유 ID (기본 키)
     */
    private Integer deliveryId;

    /**
     * 주문 ID (외래키, order 테이블과 연관)
     */
    private Integer orderId;

    /**
     * 배송 상태 (0: 미배송, 1: 배송 완료)
     */
    private Integer deliveryCheck;

    /**
     * 배송 시작 일자
     */
    private Date deliveryDate;

    /**
     * 배송 완료 일자
     */
    private Date deliveryFinDate;
}
