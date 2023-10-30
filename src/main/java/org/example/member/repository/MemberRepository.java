package org.example.member.repository;

import org.example.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> members = new ArrayList<>();
    public void create(String userId, String password) {
        Member member = new Member(userId, password);
        members.add(member);
    }
    public Member getMemberById(String userId) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getUserId().equals(userId)) {
                return member;
            }
        } return null;
    }
}

