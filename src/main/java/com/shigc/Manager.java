package com.shigc;

import java.util.Scanner;

/**
 * @author shigc
 */
public class Manager {

    Manager() {
        // 选择搜索方式，1为不登陆，2为登录
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        printMainMenu1();
        String choiceStr = scanner.nextLine();
        while (! "1".equals(choiceStr) && !"2".equals(choiceStr)) {
            System.out.println("输入错误，请重新输入：");
            choiceStr = scanner.nextLine();
        }
        choice = Integer.parseInt(choiceStr);
        while (true) {
            if (choice == 1) {
                // 不登陆，只能搜索第一页大概16条数据
                SearchTools.searchKnowledgeWithoutLogin();
            } else {
                SearchTools.searchKnowledgeWithLogin();
            }
        }
    }

    public void printMainMenu1() {
        System.out.println("1. 不登陆，只能搜索大概12条数据");
        System.out.println("2. 登陆，可以搜索所有数据");
    }

}
