package com.chacha.create.common.mapper.chat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.chat.ChatroomEntity;

/**
 * chatroom 테이블에 대한 CRUD 작업을 수행하는 MyBatis 매퍼 인터페이스입니다.
 */
@Mapper
public interface ChatroomMapper {

    /**
     * 모든 채팅방(chatroom) 데이터를 조회합니다.
     * 
     * @return 채팅방 리스트
     */
    List<ChatroomEntity> selectAll();

    /**
     * chatroom_id로 특정 채팅방 데이터를 조회합니다.
     * 
     * @param chatroomId 조회할 채팅방 ID
     * @return 조회된 ChatroomEntity 객체 (없으면 null)
     */
    ChatroomEntity selectByChatroomId(int chatroomId);

    /**
     * store_id로 채팅방 리스트를 조회합니다.
     * 
     * @param storeId 조회할 가게 ID
     * @return 해당 가게의 채팅방 리스트
     */
    List<ChatroomEntity> selectByStoreId(int storeId);

    /**
     * member_id로 채팅방 리스트를 조회합니다.
     * 
     * @param memberId 조회할 회원 ID
     * @return 해당 회원의 채팅방 리스트
     */
    List<ChatroomEntity> selectByMemberId(int memberId);

    /**
     * 새로운 채팅방을 삽입합니다.
     * seq_chatroom_id 시퀀스를 사용하여 chatroom_id가 자동 생성됩니다.
     * 
     * @param entity 삽입할 ChatroomEntity 객체
     * @return 삽입 성공 시 영향 받은 행 수
     */
    int insert(ChatroomEntity entity);

    /**
     * 기존 채팅방 정보를 수정합니다.
     * 
     * @param entity 수정할 ChatroomEntity 객체
     * @return 수정 성공 시 영향 받은 행 수
     */
    int update(ChatroomEntity entity);

    /**
     * chatroom_id로 채팅방을 삭제합니다.
     * 
     * @param chatroomId 삭제할 채팅방 ID
     * @return 삭제 성공 시 영향 받은 행 수
     */
    int delete(int chatroomId);
}
