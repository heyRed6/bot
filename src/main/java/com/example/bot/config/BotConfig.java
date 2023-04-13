package com.example.bot.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * @author heyred
 */
@Configuration
public class BotConfig {
    //ip
    public static final String PROXY_HOST = "127.0.0.1";
    // 本地监听的端口
    public static final int PROXY_PORT = 7890;

    @Bean
    public DefaultBotOptions defaultBotOptions() {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        botOptions.setProxyHost(PROXY_HOST);
        botOptions.setProxyPort(PROXY_PORT);
        //ProxyType是个枚举
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        return botOptions;
    }

    @Bean
    public DefaultBotSession DefaultBotSession() {
        DefaultBotSession defaultBotSession = new DefaultBotSession();
        defaultBotSession.setOptions(defaultBotOptions());
        return defaultBotSession;
    }

    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi() {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession().getClass());
        return api;
    }

}
