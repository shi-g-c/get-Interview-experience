package com.shigc;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import lombok.extern.slf4j.Slf4j;

/**
 *  Client工具类
 */
@Slf4j
public class ClientTool {
    /**
     * 全局唯一的webClient
     */
    private static WebClient webClient;

    /**
     * 获取webClient
     * @return webClient
     */
    public static WebClient getWebClient() {
        //如果webClient为空，创建一个新的
        if(webClient == null) {
            webClient = new WebClient(BrowserVersion.FIREFOX_ESR);
            /*配置webClient*/
            //ajax
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            //支持js
            webClient.getOptions().setJavaScriptEnabled(true);
            //忽略js错误
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            //忽略css错误
            webClient.setCssErrorHandler(new SilentCssErrorHandler());
            //不执行CSS渲染
            webClient.getOptions().setCssEnabled(false);
            //超时时间
            webClient.getOptions().setTimeout(100000);
            //允许重定向
            webClient.getOptions().setActiveXNative(false);
            //允许重定向
            webClient.getOptions().setRedirectEnabled(true);
            //允许cookie
            webClient.getCookieManager().setCookiesEnabled(true);
            // 设置Ajax异步处理控制器即启用Ajax支持
            webClient.setJavaScriptTimeout(1000);
        }
        log.info("获取webClient");
        return webClient;
    }
}
