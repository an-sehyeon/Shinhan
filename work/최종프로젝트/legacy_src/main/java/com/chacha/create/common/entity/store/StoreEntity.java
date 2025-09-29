package com.chacha.create.common.entity.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 상점(Store) 정보를 담는 엔티티 클래스입니다.
 * <p>
 * DB의 {@code store} 테이블과 매핑되며,
 * 판매자가 운영하는 개별 상점 정보를 나타냅니다.
 * </p>
 *
 * <pre>
 * 필드 설명:
 * - storeId      : 상점 고유 ID (기본 키)
 * - sellerId     : 상점 소유 판매자의 ID (외래 키)
 * - logoImg      : 상점 로고 이미지 경로 또는 URL
 * - storeName    : 상점 이름
 * - storeDetail  : 상점 소개 및 설명
 * - storeUrl     : 상점 고유 URL 또는 링크 주소
 * - saleCnt      : 상점 누적 판매 건수
 * - viewCnt      : 상점 누적 조회 수
 * </pre>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StoreEntity {

    /** 상점 고유 ID */
    private Integer storeId;

    /** 상점 소유 판매자 ID */
    private Integer sellerId;

    /** 상점 로고 이미지 경로 또는 URL */
    private String logoImg;

    /** 상점 이름 */
    private String storeName;

    /** 상점 설명 */
    private String storeDetail;

    /** 상점 고유 URL */
    private String storeUrl;

    /** 상점 총 판매 횟수 */
    private Integer saleCnt;

    /** 상점 총 조회수 */
    private Integer viewCnt;
}
