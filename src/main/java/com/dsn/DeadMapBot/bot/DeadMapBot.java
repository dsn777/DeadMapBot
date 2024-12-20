package com.dsn.DeadMapBot.bot;

import com.dsn.DeadMapBot.bot.callback.Callback;
import com.dsn.DeadMapBot.bot.handler.CallbackHandler;
import com.dsn.DeadMapBot.bot.handler.CommandHandler;
import com.dsn.DeadMapBot.bot.handler.StateHandler;
import com.dsn.DeadMapBot.configuration.BotProperties;
import com.dsn.DeadMapBot.service.ChatService;
import com.dsn.DeadMapBot.service.DeadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class DeadMapBot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final DeadService deadService;
    private final CommandHandler commandHandler;
    private final ChatService chatService;
    private final CallbackHandler callbackHandler;
    private final StateHandler stateHandler;

    public DeadMapBot(@Value("${bot.token}")
                      String token,
                      BotProperties botProperties,
                      DeadService deadService,
                      CommandHandler commandHandler,
                      ChatService chatService,
                      CallbackHandler callbackHandler,
                      StateHandler stateHandler
    ) {
        super(token);
        this.botProperties = botProperties;
        this.deadService = deadService;
        this.commandHandler = commandHandler;
        this.chatService = chatService;
        this.callbackHandler = callbackHandler;
        this.stateHandler = stateHandler;
    }

    private Long getChatId(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }

        return update.hasCallbackQuery()
                ? update.getCallbackQuery().getFrom().getId()
                : update.getMessage().getChatId();
    }

    @Override
    public void onUpdateReceived(Update update) {
        var chatId = getChatId(update);
        chatService.saveChat(chatId);

        SendMessage sendMessage = new SendMessage(chatId.toString(), "0_о");

        if (update.hasMessage()) {
            if (update.getMessage().getText().startsWith("/")) {
                var potentialCommand = update.getMessage().getText();
                sendMessage = commandHandler.handleCommand(chatId, potentialCommand);
            } else {
                sendMessage = stateHandler.handleChatState(chatId, update.getMessage().getText());
            }
        } else if (update.hasCallbackQuery()) {
            sendMessage = callbackHandler.handleCallback(chatId, update.getCallbackQuery().getData());
        }

        sendMessage.enableHtml(true);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }
}
