package com.shigc;

import java.util.regex.Pattern;

public interface Constant {
    /**
     * 主页url
     */
    String MAIN_URL = "https://www.nowcoder.com/search/all?";

    /**
     * 帖子详情url
     */
    String POST_URL = "https://www.nowcoder.com/feed/main/detail/";

    /**
     * 从搜索页面匹配帖子id的正则表达式
     */
    Pattern COMPILE = Pattern.compile("feed/main/detail/[0-9a-z]{32}");

    /**
     * 从搜索页面匹配帖子id的正则表达式2
     */
    Pattern COMPILE2 = Pattern.compile("\"uuid\":\"[0-9a-z]{32}\",\"userId\"");
}
