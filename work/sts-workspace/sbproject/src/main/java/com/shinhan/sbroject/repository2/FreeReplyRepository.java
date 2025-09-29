package com.shinhan.sbroject.repository2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.sbroject.entity2.FreeBoardEntity;
import com.shinhan.sbroject.entity2.FreeReplyEntity;


public interface FreeReplyRepository extends JpaRepository<FreeReplyEntity, Long> {

	List<FreeReplyEntity> findByBoard(FreeBoardEntity board);
}
