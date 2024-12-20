package com.dsn.DeadMapBot.bot.command.commandImpl;


import com.dsn.DeadMapBot.bot.command.Command;
import com.dsn.DeadMapBot.bot.util.TextFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements Command {

    @Value("${commands.start}")
    private String name;
    private static final String START_TEXT =
            TextFormatter.italic(
                    TextFormatter.bold("Приветствуем в боте проекта \"Карта кладбища\"! ")
            ) + "\n" + "\n" +
                    "Здесь вы можете:" + "\n" +
                    "- заранее проложить путь к местоположению могилы, мемориала или кладбища" + "\n" +
                    "- обратиться в нашу поддержку" + "\n" +
                    "- оставить отзывы и предложения" + "\n" +
                    "- отправить запрос на добавление данных о человеке" + "\n" + "\n" +
                    TextFormatter.italic("Удачного пользования!");

    @Override
    public SendMessage execute(Long chatId) {
        return new SendMessage(chatId.toString(), START_TEXT);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
