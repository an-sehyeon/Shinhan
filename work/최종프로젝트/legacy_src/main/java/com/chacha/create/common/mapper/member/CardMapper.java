package com.chacha.create.common.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.member.CardEntity;

/**
 * card 테이블에 대한 CRUD 작업을 수행하는 MyBatis 매퍼 인터페이스입니다.
 */
@Mapper
public interface CardMapper {

    /**
     * 모든 카드 정보를 조회합니다.
     * 
     * @return 카드 리스트
     */
    List<CardEntity> selectAll();

    /**
     * card_id로 특정 카드 정보를 조회합니다.
     * 
     * @param cardId 조회할 카드 ID
     * @return 조회된 CardEntity 객체 (없으면 null)
     */
    CardEntity selectByCardId(int cardId);

    /**
     * 새로운 카드 정보를 삽입합니다.
     * seq_card_id 시퀀스를 사용하여 card_id가 자동 생성됩니다.
     * 
     * @param entity 삽입할 CardEntity 객체
     * @return 삽입 성공 시 영향 받은 행 수
     */
    int insert(CardEntity entity);

    /**
     * 기존 카드 정보를 수정합니다.
     * 
     * @param entity 수정할 CardEntity 객체
     * @return 수정 성공 시 영향 받은 행 수
     */
    int update(CardEntity entity);

    /**
     * card_id로 카드 정보를 삭제합니다.
     * 
     * @param cardId 삭제할 카드 ID
     * @return 삭제 성공 시 영향 받은 행 수
     */
    int delete(int cardId);
}
