package com.shigc;

import cn.hutool.http.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shigc
 */
public class PostTools {

    /**
     * 从帖子中获取关键字所在行
     * @param postUrl 帖子url
     * @param keyWord 关键字
     */
    public static void getPostLines(String postUrl, String keyWord) {
        String string = HttpUtil.get(postUrl);
        // 设置最小匹配
        Pattern compile = Pattern.compile("<br />.*?"+ keyWord+".*?<br />");
        // 设置最小匹配
        Matcher matcher = compile.matcher(string);
        while (matcher.find()) {
            String group = matcher.group();
            String[] split = group.split("<br />");
            for (String s : split) {
                if (s.contains(keyWord)) {
                    System.out.println(s);
                }
            }
        }
    }
}
