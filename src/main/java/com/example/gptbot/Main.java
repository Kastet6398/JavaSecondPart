package com.example.gptbot;


import com.example.gptbot.utils.Constants;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public final class Main {
    public static void main(String[] args) {
        if (Constants.OPENAI_KEY.equals("****************")) {
            System.out.println("Please replace the OPENAI_KEY constant (at com.example.gptbot.utils.Constants:4) with your real one.");
        } else {
            try {
                TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                botsApi.registerBot(new GptBot(Constants.BOT_TOKEN));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

