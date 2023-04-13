package com.example.bot.controller;

import com.example.bot.MyBot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;

/**
 * @author heyred
 */
@RestController
public class BotController {
    @Resource
    private TelegramBotsApi telegramBotsApi;
    @Resource
    private DefaultBotOptions defaultBotOptions;

    @GetMapping("/start")
    public String start() {
        try {
            MyBot myBot = new MyBot(defaultBotOptions);
            telegramBotsApi.registerBot(myBot);
        } catch (TelegramApiException e) {
            return "启动失败";
        }
        return "启动成功";
    }
}
