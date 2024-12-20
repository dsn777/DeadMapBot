package com.dsn.DeadMapBot.entity;

import com.dsn.DeadMapBot.bot.BotState;
import com.dsn.DeadMapBot.dto.DeadDto;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
public class Chat {
    private Long id;
    private DeadDto deadDto;
    private BotState state;

    public Chat(Update update) {
        this.id = update.getMessage().getChatId();
        this.deadDto = new DeadDto();
        this.state = BotState.DEFAULT_STATE;
    }

    public Chat(Long id) {
        this.id = id;
        this.deadDto = new DeadDto();
        this.state = BotState.DEFAULT_STATE;
    }
}
