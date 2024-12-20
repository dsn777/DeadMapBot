package com.dsn.DeadMapBot.bot.handler;

import com.dsn.DeadMapBot.bot.callback.AllCallbacks;
import com.dsn.DeadMapBot.bot.callback.Callback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@RequiredArgsConstructor
public class CallbackHandler {
    private final AllCallbacks callbacks;

    public SendMessage handleCallback(Long chatId, String callbackName) {
        Callback callback = callbacks.getCallback(callbackName);
        return callback.handle(chatId);
    }
}
