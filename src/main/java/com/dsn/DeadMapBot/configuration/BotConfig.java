//package com.dsn.DeadMapBot.configuration;
//
//import com.dsn.DeadMapBot.bot.DeadMapBot;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//
//@Configuration
//public class BotConfig {
//
//    @Bean
//    public TelegramBotsApi telegramBotsApi(DeadMapBot deadMapBot) throws TelegramApiException {
//        var api = new TelegramBotsApi(DefaultBotSession.class);
//        api.registerBot(deadMapBot);
//        return api;
//    }
//}
