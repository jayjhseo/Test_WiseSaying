package org.example.member.service;

import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    public void create(String userId, String password) {
        memberRepository.create(userId, password);
    }
    public Member getMemberById(String userId) {
        return memberRepository.getMemberById(userId);
    }
}
