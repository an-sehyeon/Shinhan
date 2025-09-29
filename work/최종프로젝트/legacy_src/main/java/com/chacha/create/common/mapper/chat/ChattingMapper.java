package com.chacha.create.common.mapper.chat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.chat.ChattingEntity;

/**
 * chatting 테이블에 대한 CRUD 작업을 수행하는 MyBatis 매퍼 인터페이스입니다.
 */
@Mapper
public interface ChattingMapper {

    /**
     * 모든 채팅 데이터를 조회합니다.
     * 
     * @return 채팅 리스트
     */
    List<ChattingEntity> selectAll();

    /**
     * chatting_id로 특정 채팅 데이터를 조회합니다.
     * 
     * @param chattingId 조회할 채팅 ID
     * @return 조회된 ChattingEntity 객체 (없으면 null)
     */
    ChattingEntity selectByChattingId(int chattingId);

    /**
     * chatroom_id로 채팅 리스트를 조회합니다.
     * 
     * @param chatroomId 조회할 채팅방 ID
     * @return 해당 채팅방의 채팅 리스트
     */
    List<ChattingEntity> selectByChatroomId(int chatroomId);

    /**
     * 새로운 채팅 데이터를 삽입합니다.
     * seq_chatroom_id 시퀀스를 사용하여 chatting_id가 자동 생성됩니다.
     * 
     * @param entity 삽입할 ChattingEntity 객체
     * @return 삽입 성공 시 영향 받은 행 수
     */
    int insert(ChattingEntity entity);

    /**
     * 기존 채팅 데이터를 수정합니다.
     * 
     * @param entity 수정할 ChattingEntity 객체
     * @return 수정 성공 시 영향 받은 행 수
     */
    int update(ChattingEntity entity);

    /**
     * chatting_id로 채팅 데이터를 삭제합니다.
     * 
     * @param chattingId 삭제할 채팅 ID
     * @return 삭제 성공 시 영향 받은 행 수
     */
    int delete(int chattingId);
}
