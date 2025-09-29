package com.chacha.create.common.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.order.DeliveryEntity;

/**
 * delivery 테이블에 대한 CRUD 작업을 수행하는 MyBatis 매퍼 인터페이스입니다.
 */
@Mapper
public interface DeliveryMapper {

    /**
     * 모든 배송 정보를 조회합니다.
     *
     * @return 배송 엔티티 리스트
     */
    List<DeliveryEntity> selectAll();

    /**
     * deliveryId로 특정 배송 정보를 조회합니다.
     *
     * @param deliveryId 조회할 배송 ID
     * @return 조회된 DeliveryEntity 객체 (없으면 null)
     */
    DeliveryEntity selectByDeliveryId(int deliveryId);

    /**
     * orderId로 특정 배송 정보를 조회합니다.
     *
     * @param orderId 조회할 주문 ID
     * @return 조회된 DeliveryEntity 객체 (없으면 null)
     */
    DeliveryEntity selectByOrderId(int orderId);

    /**
     * 새로운 배송 정보를 삽입합니다.
     * seq_delivery_id 시퀀스를 사용하여 delivery_id가 자동 생성됩니다.
     *
     * @param delivery 삽입할 DeliveryEntity 객체
     * @return 삽입 성공 시 영향 받은 행 수
     */
    int insert(DeliveryEntity delivery);

    /**
     * 기존 배송 정보를 수정합니다.
     *
     * @param delivery 수정할 DeliveryEntity 객체
     * @return 수정 성공 시 영향 받은 행 수
     */
    int update(DeliveryEntity delivery);

    /**
     * deliveryId로 배송 정보를 삭제합니다.
     *
     * @param deliveryId 삭제할 배송 ID
     * @return 삭제 성공 시 영향 받은 행 수
     */
    int delete(int deliveryId);
}
