package com.dsn.DeadMapBot.bot.callback.callbackImpl;

import com.dsn.DeadMapBot.bot.BotState;
import com.dsn.DeadMapBot.bot.callback.Callback;
import com.dsn.DeadMapBot.service.ChatService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class LastnameSearchCallback implements Callback {

    private final ChatService chatService;
    private final String name = "/find_by_lastname";
    private final String buttonText = "Введите фамилию";

    @Override
    public SendMessage handle(Long chatId) {
        chatService.getChat(chatId).setState(BotState.WAIT_LASTNAME);
        return new SendMessage(chatId.toString(), buttonText);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
