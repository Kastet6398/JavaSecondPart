package com.example.gptbot;

import com.example.gptbot.utils.Constants;
import com.example.gptbot.utils.OpenAIAPIRequest;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GptBot extends TelegramLongPollingBot {
    public GptBot(String key) {
        super(key);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            Long chat_id = update.getMessage().getChatId();
            if (message_text.startsWith("/ai")) {
                String query = message_text.substring(3).trim();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                String response;
                if (query.replaceAll("\\s", "").isBlank()) {
                    response = "It seams like your message is empty or consists only of spaces.";
                } else {
                    try {
                        response = OpenAIAPIRequest.getAIResponse(query);
                    } catch (Exception e) {
                        e.printStackTrace();
                        response = "Something went wrong: " + e.getMessage();
                    }
                }
                sendMessage.setText(response);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/start")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chat_id);
                sendMessage.setText("Hello! Use the /ai command, like this: /ai 2+2 to talk to me. Note that I can only speak English. Please ask me once per 10s.");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return Constants.BOT_USERNAME;
    }
}
