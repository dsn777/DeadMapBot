package com.dsn.DeadMapBot.bot.command.commandImpl;

import com.dsn.DeadMapBot.bot.command.Command;
import com.dsn.DeadMapBot.bot.util.TextFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:support.properties")
public class SupportCommand implements Command {

    private final String name;
    private final String SUPPORT_TEXT;

    public SupportCommand(@Value("${support.email}") String email,
                          @Value("${support.phone}") String phone,
                          @Value("${commands.support}") String name) {
        this.name = name;
        this.SUPPORT_TEXT = "Контактные данные\n" +
                TextFormatter.bold("Почта: ") + email + "\n" +
                TextFormatter.bold("Телефон: ") + phone;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public SendMessage execute(Long chatId) {
        return new SendMessage(chatId.toString(), SUPPORT_TEXT);
    }
}
