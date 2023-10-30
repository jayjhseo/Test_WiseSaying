package org.example;

import org.example.db.DBConnection;
import org.example.member.controller.MemberController;
import org.example.member.entity.Member;
import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class App {
    WiseSayingController wiseSayingController = new WiseSayingController();
    MemberController memberController = new MemberController();
    DBConnection dbConnection = new DBConnection();
    public App () {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
        Container.getDBconnection().
//        Container.getDBconnection().insert(
//                "INSERT INTO article " +
//                "SET id = 3,\n" +
//                "title = \"test3\",\n" +
//                "content = \"test3\",\n" +
//                "memberId = 1,\n" +
//                "regDate = now()");
//        Container.getDBconnection().delete(
//                "DELETE FROM article"
//        );

//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("SELECT * FROM article"));

//        List<WiseSaying> wiseSayings =  new ArrayList<>();
//
//        List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
//
//        for (Map<String, Object> row : rows) {
//            System.out.println(row);
//        }
    }



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
                    memberController.join();
                    break;

                case "로그인":
                    memberController.logIn();
                    break;
                case "로그아웃":
                    memberController.logOut();
                    break;
            }
        }
    }
}