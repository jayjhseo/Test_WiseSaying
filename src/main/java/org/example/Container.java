package org.example;

import lombok.Getter;

import java.util.Scanner;

public class Container {
    @Getter
    private static Scanner sc;
    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void exit() {
        sc.close();
    }
}
