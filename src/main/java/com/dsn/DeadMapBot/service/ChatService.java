package com.dsn.DeadMapBot.service;

import com.dsn.DeadMapBot.bot.BotState;
import com.dsn.DeadMapBot.entity.Chat;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class ChatService {
    private final Map<Long, Chat> chats = new HashMap<>();

    public Chat getChat(Long id) {
        return chats.get(id);
    }

    public void saveChat(Long id) {
        var savedChat = getChat(id);
        if (savedChat == null) {
            chats.put(id, new Chat(id));
        }
    }

    public void nextState(Long id) {
        var chat = chats.get(id);
        var nextState = BotState.getNextState(chat.getState());
        chat.setState(nextState);
    }

    public void setDefaultState(Long id) {
        var chat = chats.get(id);
        chat.setState(BotState.DEFAULT_STATE);
    }
}
