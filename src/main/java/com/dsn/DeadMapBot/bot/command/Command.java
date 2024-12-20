package com.dsn.DeadMapBot.bot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public interface Command {
    String getName();
    SendMessage execute(Long chatId);
}
