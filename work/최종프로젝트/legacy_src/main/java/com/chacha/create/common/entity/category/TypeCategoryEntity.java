package com.chacha.create.common.entity.category;

import com.chacha.create.common.enums.category.TypeCategoryEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 수공예 기법 카테고리 엔티티 클래스
 * <p>
 * DB의 {@code type_category} 테이블과 매핑되는 클래스입니다.
 * 각 상품이 어떤 수공예 방식(금속공예, 목공예 등)으로 제작되었는지를 나타냅니다.
 * </p>
 *
 * <pre>
 * 예시 데이터:
 * typeCategory: TypeCategoryEnum.METAL (금속공예)
 * </pre>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TypeCategoryEntity {

    /** 수공예 기법 enum (기본 키 역할) */
    private TypeCategoryEnum typeCategoryId;

    /** 수공예 기법 이름 (예: 금속공예, 목공예 등) */
    private String typeCategoryName;
}
