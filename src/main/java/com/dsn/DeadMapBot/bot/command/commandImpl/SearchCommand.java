package com.dsn.DeadMapBot.bot.command.commandImpl;

import com.dsn.DeadMapBot.bot.command.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchCommand implements Command {

    @Value("${commands.search}")
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public SendMessage execute(Long chatId) {
        String text = "Выберите действие:";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(getKeyBoard());
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    private InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(getSingleButtonList("Поиск по фамилии", "/find_by_lastname"));
        keyboard.add(getSingleButtonList("Поиск по ID", "/find_by_id"));
        markupInline.setKeyboard(keyboard);
        return markupInline;
    }

    private List<InlineKeyboardButton> getSingleButtonList(String buttonText,
                                                           String callbackData) {
        var button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callbackData);
        return List.of(button);
    }
}
