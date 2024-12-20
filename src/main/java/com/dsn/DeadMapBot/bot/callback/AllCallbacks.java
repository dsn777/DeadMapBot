package com.dsn.DeadMapBot.bot.callback;

import com.dsn.DeadMapBot.bot.command.Command;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AllCallbacks {
    private final Map<String, Callback> callbackMap;

    public AllCallbacks(List<Callback> callbackList) {
        callbackMap = new HashMap<>();
        callbackList.forEach(callback -> callbackMap.put(callback.getName(), callback));
    }

    public Callback getCallback(String name) {
        return callbackMap.get(name);
    }
}
