package org.example;

import org.example.utils.Dao;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.example.utils.Constants;

public class Main {

    public static void main(String[] args) throws TelegramApiException {
        Dao.createTables();
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(new Bot(Constants.BOT_TOKEN));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
