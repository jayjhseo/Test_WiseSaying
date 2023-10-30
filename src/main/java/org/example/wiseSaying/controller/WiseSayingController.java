package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;


public class WiseSayingController {
    WiseSayingService wiseSayingService = new WiseSayingService();


    public void write() {
        if(Container.getLoginedMember() == null) {
            System.out.println("로그인 후 이용해주세요");
            return;
        }
        System.out.print("명언: ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가: ");
        String author = Container.getSc().nextLine().trim();

        long id = wiseSayingService.create(author, content);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        wiseSayingService.getAllList();
    }

    public void remove() {
        if(Container.getLoginedMember() == null) {
            System.out.println("로그인 후 이용해주세요");
            return;
        }
        System.out.println("삭제할 명언의 ID값을 입력하세요");
        long id = Long.parseLong(Container.getSc().nextLine().trim());
        WiseSaying wiseSaying = wiseSayingService.getWiseSayingsById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
            return;
        }
        wiseSayingService.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify() {
        if(Container.getLoginedMember() == null) {
            System.out.println("로그인 후 이용해주세요");
            return;
        }
        System.out.println("수정할 명언의 ID값을 입력하세요");
        long id = Long.parseLong(Container.getSc().nextLine().trim());
        WiseSaying wiseSaying = wiseSayingService.getWiseSayingsById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번명언이 존재하지 않습니다.\n", id);
            return;
        }
        System.out.print("수정 작가: ");
        String author = Container.getSc().nextLine();
        System.out.print("수정 명언: ");
        String content = Container.getSc().nextLine();

        wiseSayingService.modify(wiseSaying, author, content);

        System.out.printf("%d번명언이 수정되었습니다.\n", id);
    }
}


