package com.dsn.DeadMapBot.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Slf4j
@RequiredArgsConstructor
@Component
public class BotInit {

    private final DeadMapBot deadMapBot;

//    @EventListener({ContextRefreshedEvent.class})
//    public void init() throws TelegramApiException {
//        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//        telegramBotsApi.registerBot(deadMapBot);
//    }

    @Bean
    public TelegramBotsApi init() throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(deadMapBot);
        return telegramBotsApi;
    }
}
