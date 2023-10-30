package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.ArrayList;
import java.util.List;


public class App {
    WiseSayingController wiseSayingController = new WiseSayingController();
    List<Member> members = new ArrayList<>();
    Member loginedMember = null;

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            switch (command) {
                case "종료":
                    SystemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove();
                    break;
                case "수정":
                    wiseSayingController.modify();
                    break;
                case "회원가입":
                    String userId;
                    String password;
                    String passwordConfirm;
                    while (true) {
                        System.out.print("아이디: ");
                        userId = Container.getSc().nextLine();
                        boolean checkId = false;
                        for (int i = 0; i < members.size(); i++) {
                            Member member = members.get(i);
                            if (member.getUserId().equals(userId)) {
                                checkId = true;
                            }
                        }
                        if (checkId) {
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
                    System.out.println("회원가입을 축하합니다.");
                    Member member = new Member(userId, password);
                    members.add(member);
                    break;

                case "로그인":
                    if (loginedMember != null) {
                        System.out.println("이미 로그인이 되어있습니다.");
                        continue;
                    }
                    boolean checkId = false;
                    member = null;
                    System.out.print("아이디: ");
                    userId = Container.getSc().nextLine();
                    for (int i = 0; i < members.size(); i++) {
                        member = members.get(i);
                        if (member.getUserId().equals(userId)) {
                            checkId = true;
                        }
                    }
                    if (checkId == false) {
                        System.out.println("해당 아이디가 존재하지 않습니다.");
                        continue;
                    }
                    System.out.print("비밀번호: ");
                    password = Container.getSc().nextLine();
                    if (member.getPassword().equals(password) == false) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        continue;
                    }
                    loginedMember = member;
                    System.out.printf("%s님 환영합니다. 로그인 성공.\n", loginedMember);
                    break;
                case "로그아웃":
                    if (loginedMember == null) {
                        System.out.println("로그인 상태가 아닙니다.");
                    }
                    loginedMember = null;
                    System.out.println("로그아웃 되었습니다.");
                    break;
            }
        }
    }
}
// 명언앱 리팩토링후 로그인, 회원가입 기능을 만들때 조심해야대는점