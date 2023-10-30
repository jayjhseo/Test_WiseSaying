package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.db.DBConnection;
import org.example.member.entity.Member;

import java.util.Scanner;

public class Container {
    @Getter
    @Setter
    private static Scanner sc;
    @Getter
    @Setter
    private static Member loginedMember;
    private static DBConnection dbConnection;
    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void exit() {
        sc.close();
    }
    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        } return dbConnection;
    }
}
