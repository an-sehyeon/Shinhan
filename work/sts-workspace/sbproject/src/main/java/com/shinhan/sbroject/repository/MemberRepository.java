package com.shinhan.sbroject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.sbroject.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String>{

}
