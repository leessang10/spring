package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 멤버를 저장하는 기능
    Member save(Member member);

    // id 기준으로 Member를 조회하는 기능
    Optional<Member> findById(Long id);

    // name 기준으로 Member를 조회하는 기능
    Optional<Member> findByName(String name);

    // 전체 Member 목록을 조회하는 기능
    List<Member> findAll();
}
