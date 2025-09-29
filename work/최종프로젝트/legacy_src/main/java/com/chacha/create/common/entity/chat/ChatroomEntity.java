package com.chacha.create.common.entity.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 채팅방 정보를 나타내는 엔티티 클래스입니다.
 * <p>
 * 이 클래스는 DB의 {@code chatroom} 테이블과 매핑되며,
 * 회원(member)과 판매자(store) 간의 1:1 채팅방을 표현합니다.
 * </p>
 *
 * <pre>
 * 예시:
 * - chatroomId: 1001
 * - storeId: 200 (판매자 상점 ID)
 * - memberId: 305 (구매자 또는 일반 사용자 ID)
 * </pre>
 *
 * @author
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatroomEntity {

    /**
     * 채팅방 ID (기본 키)
     */
    private Integer chatroomId;

    /**
     * 채팅방이 연결된 상점 ID (외래키)
     */
    private Integer storeId;

    /**
     * 채팅에 참여한 회원 ID (외래키)
     */
    private Integer memberId;
}
