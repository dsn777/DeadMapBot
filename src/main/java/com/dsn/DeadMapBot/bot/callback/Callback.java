package com.dsn.DeadMapBot.bot.callback;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Callback {
    SendMessage handle(Long chatId);
    String getName();
}
