package com.dsn.DeadMapBot.configuration;//package com.dsn.TelegramDeadMapBot.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BotProperties {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.name}")
    private String name;
}
