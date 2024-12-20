package com.dsn.DeadMapBot.bot.command.commandImpl;

import com.dsn.DeadMapBot.bot.command.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AddCommand implements Command {

    @Value("${commands.add}")
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    private final String LINK = "daynBot.com";
    private final String ADD_TEXT = "Заполните форму для добавления данных: " + LINK;

    @Override
    public SendMessage execute(Long chatId) {
        var chatIdStr = chatId.toString();
        return new SendMessage(chatIdStr, ADD_TEXT);
    }
}
