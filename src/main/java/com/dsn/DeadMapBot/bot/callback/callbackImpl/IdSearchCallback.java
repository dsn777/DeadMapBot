package com.dsn.DeadMapBot.bot.callback.callbackImpl;

import com.dsn.DeadMapBot.bot.BotState;
import com.dsn.DeadMapBot.bot.callback.Callback;
import com.dsn.DeadMapBot.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@RequiredArgsConstructor
public class IdSearchCallback implements Callback {

    private final ChatService chatService;
    private final String name = "/find_by_id";
    private final String buttonText = "Введите ID:";

    @Override
    public SendMessage handle(Long chatId) {
        chatService.getChat(chatId).setState(BotState.WAIT_ID);
        return new SendMessage(chatId.toString(), buttonText);
    }

    @Override
    public String getName() {
        return this.name;
    }
}

