package com.dsn.DeadMapBot.bot.handler;

import com.dsn.DeadMapBot.bot.BotState;
import com.dsn.DeadMapBot.bot.util.TextFormatter;
import com.dsn.DeadMapBot.dto.DeadDto;
import com.dsn.DeadMapBot.service.ChatService;
import com.dsn.DeadMapBot.service.DeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StateHandler {

    private final ChatService chatService;
    private final DeadService deadService;

    public SendMessage handleChatState(Long chatId, String text) {

        //Callback callback = stateMap.get()
        //SendMessage sendMessage =

        var chat = chatService.getChat(chatId);
        var chatState = chat.getState();

        String textToSend;
        if (chatState.equals(BotState.WAIT_LASTNAME)) {
            var dto = chat.getDeadDto();
            dto.setLastname(text);
            chatService.setDefaultState(chatId);
            var findedDtoList = deadService.findByLastname(dto.getLastname());
            textToSend = findedDtoList.isEmpty()
                    ? "Захороненный не найден..."
                    : findedDtoList.stream()
                    .map(DeadDto::of)
                    .map(TextFormatter::getFormattedDead)
                    .collect(Collectors.joining());

            return new SendMessage(chatId.toString(), textToSend);
        }

        if (chatState.equals(BotState.WAIT_ID)) {
            var dto = chat.getDeadDto();
            dto.setLastname(text);
            chatService.setDefaultState(chatId);

            long deadId;
            try {
                deadId = Long.parseLong(text);
                var findedDeadEntity = deadService.findById(deadId);
                textToSend = findedDeadEntity
                        .map(deadEntity -> TextFormatter.getFormattedDead(DeadDto.of(deadEntity)))
                        .orElse("Захороненный не найден...");
            } catch (NumberFormatException e) {
                textToSend = "Неверный ввод!";
            }




            return new SendMessage(chatId.toString(), textToSend);
        }

        return new SendMessage(chatId.toString(), "0_o");
    }
}


//class WaitFirstnameState {
//
//}