package com.tibetyo.ible.repository;

import domain.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import repository.MemberRepository;

@SpringBootTest
//@Transactional
//@ContextConfiguration(classes = MemberRepository.class)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void member_test(){
        Member member = new Member();
        //member.setGroup(GroupName.aespa);
        member.setPassword("abcde");
        memberRepository.save(member);
    }
}