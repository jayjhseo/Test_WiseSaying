package org.example.member.controller;

import org.example.Container;
import org.example.member.entity.Member;
import org.example.member.service.MemberService;

public class MemberController {

    MemberService memberService = new MemberService();

    public void join() {
        String userId;
        String password;
        String passwordConfirm;
        while (true) {
            System.out.print("아이디: ");
            userId = Container.getSc().nextLine();
            Member member = memberService.getMemberById(userId);
            if (member != null) {
                System.out.println("해당 아이디가 이미 존재합니다.");
                continue;
            }
            System.out.println("사용가능한 ID입니다.");
            break;
        }
        while (true) {
            System.out.print("비밀번호: ");
            password = Container.getSc().nextLine();
            System.out.print("비밀번호 확인: ");
            passwordConfirm = Container.getSc().nextLine();

            if (password.equals(passwordConfirm) == false) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            } break;
        }
        memberService.create(userId, password);
        System.out.println("회원가입을 축하합니다.");
    }

    public void logIn() {
        if (Container.getLoginedMember() != null) {
            System.out.println("이미 로그인이 되어있습니다.");
            return;
        }
        String userId;
        String password;

        System.out.print("아이디: ");
        userId = Container.getSc().nextLine();
        Member member = memberService.getMemberById(userId);
        if (member == null) {
            System.out.println("해당 아이디가 존재하지 않습니다.");
            return;
        }
        System.out.print("비밀번호: ");
        password = Container.getSc().nextLine();
        if (member.getPassword().equals(password) == false) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
         Container.setLoginedMember(member);
        System.out.printf("%s님 환영합니다. 로그인 성공.\n", member);
    }

    public void logOut() {
        if (Container.getLoginedMember() == null) {
            System.out.println("로그인 상태가 아닙니다.");
        }
        Container.setLoginedMember(null);
        System.out.println("로그아웃 되었습니다.");
    }

}
