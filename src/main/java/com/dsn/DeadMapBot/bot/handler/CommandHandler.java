package com.dsn.DeadMapBot.bot.handler;

import com.dsn.DeadMapBot.bot.command.AllCommands;
import com.dsn.DeadMapBot.bot.command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@RequiredArgsConstructor
public class CommandHandler {

    private final AllCommands commands;

    public SendMessage handleCommand(Long chatId, String commandName) {
        Command command = commands.getCommand(commandName);
        return command.execute(chatId);
    }
}
