package com.shigc;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static com.shigc.Constant.MAIN_URL;

/**
 * @author shigc
 */
@Slf4j
public class SearchTools {

    public static void searchKnowledgeWithLogin(){

    }

    public static void searchKnowledgeWithoutLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的知识点的关键字：");
        String keyWord = scanner.nextLine();
        String fullUrl = MAIN_URL + "query=" + keyWord
                + "&type=all&searchType=搜索页输入框&subType=818";
        Set<String> allIds = WebTools.getPostIds(fullUrl);
        for (String id : allIds) {
            String postUrl = Constant.POST_URL + id;
            PostTools.getPostLines(postUrl, keyWord);
        }
    }

}
