package com.dsn.DeadMapBot.bot.command;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class AllCommands {

    private final Map<String, Command> commandMap;

    public AllCommands(List<Command> commandList) {
        commandMap = new HashMap<>();
        commandList.forEach(command -> commandMap.put(command.getName(), command));
    }

    public Command getCommand(String name) {
        return commandMap.get(name);
    }
}
