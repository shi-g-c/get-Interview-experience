package com.shigc;

import cn.hutool.http.HttpUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.shigc.Constant.COMPILE;
import static com.shigc.Constant.COMPILE2;

/**
 * @author shigc
 */
public class WebTools {

    /**
     * 从搜索页面获取帖子id
     * @param fullUrl 搜索页面url
     * @return 帖子id集合
     */
    public static Set<String> getPostIds(String fullUrl) {
        String html = HttpUtil.get(fullUrl);
        Set<String> all = new HashSet<>();
        getPostIdsFromHtml(html, COMPILE, all, 17, 49);
        getPostIdsFromHtml(html, COMPILE2, all, 8, 40);
        return all;
    }

    /**
     * 从html中匹配帖子id
     * @param html html
     * @param pattern 正则表达式
     * @param set 结果集
     */
    private static void getPostIdsFromHtml(String html, Pattern pattern, Set<String> set,
                                           int begin, int end) {
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String group = matcher.group();
            String id = group.substring(begin, end);
            set.add(id);
        }
    }
}
