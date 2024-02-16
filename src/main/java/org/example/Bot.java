package org.example;

import org.example.utils.Constants;
import org.example.utils.Utils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.utils.Dao.*;

public class Bot extends TelegramLongPollingBot {
    public Bot(String s) {
        super(s);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            try {
                createTables(getConnection());
                createUser(getConnection(), update.getMessage().getFrom().getUserName(), update.getMessage().getFrom().getId());
                if (messageText.equals("/history") || messageText.equalsIgnoreCase("history")) {
                    SendMessage message = new SendMessage();
                    message.setChatId(chatId);
                    ResultSet rs = fetchOperationsByUserTelegramId(getConnection(), update.getMessage().getFrom().getId());

                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    keyboardMarkup.setResizeKeyboard(true);
                    keyboardMarkup.setOneTimeKeyboard(true);

                    List<KeyboardRow> keyboard = new ArrayList<>();

                    KeyboardRow cancel = new KeyboardRow();
                    cancel.add(new KeyboardButton("\uD83D\uDD34 Cancel"));
                    keyboard.add(cancel);

                    while (rs.next()) {
                        KeyboardRow row = new KeyboardRow();
                        row.add(new KeyboardButton(rs.getString("text")));
                        keyboard.add(row);
                    }
                    message.setText("Choose one");
                    keyboardMarkup.setKeyboard(keyboard);
                    message.setReplyMarkup(keyboardMarkup);

                    try {
                        execute(message);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    if (Objects.equals(messageText, "ping")) {
                        SendMessage message = new SendMessage();
                        message.setChatId(chatId);
                        message.setText("pong");

                        try {
                            execute(message);
                        }
                        catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        if (messageText.equals("/start") || messageText.equalsIgnoreCase("show welcome message")) {
                            SendMessage message = new SendMessage();
                            message.setChatId(chatId);
                            message.setText("Hello! Type a math expression and send the message. Use /history to view your history and /start to show this message.");

                            try {
                                execute(message);
                            }
                            catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                        else if (!messageText.equalsIgnoreCase("\uD83D\uDD34 cancel")) {
                            ResultSet rs = getUserByTelegramId(getConnection(), update.getMessage().getFrom().getId());
                            if (rs.next()) {
                                createOperation(getConnection(), messageText, update.getMessage().getMessageId());
                                ResultSet rs1 = getOperationByTelegramId(getConnection(), update.getMessage().getMessageId());
                                if (rs1.next()) {
                                    createUserOperationIntermediate(getConnection(), rs.getInt("id"), rs1.getInt("id"));
                                    String res = Utils.calculate(messageText);
                                    SendMessage message = new SendMessage();
                                    message.setChatId(chatId);
                                    message.setText(res);
                                    try {
                                        execute(message);
                                    }
                                    catch (TelegramApiException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        closeConnection();

                    }
                    setupInlineKeyboardMarkup(chatId);

                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupInlineKeyboardMarkup(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow start = new KeyboardRow();
        start.add(new KeyboardButton("Show welcome message"));
        keyboard.add(start);

        KeyboardRow history = new KeyboardRow();
        history.add(new KeyboardButton("History"));
        keyboard.add(history);

        message.setText("Choose an action or type your math expression:");
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return Constants.BOT_USERNAME;
    }

}
