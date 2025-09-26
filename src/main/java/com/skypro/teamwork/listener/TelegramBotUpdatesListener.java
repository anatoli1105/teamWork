package com.skypro.teamwork.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.service.RecommendationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class TelegramBotUpdatesListener implements UpdatesListener {
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    RecommendationService service;


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);


    }


    @Override
    public int process(List<Update> updates) {

        updates.forEach(update -> {


            var id = update.message().chat().id();

            if (update.message().text().matches("(\\w+)(\\s+)(\\w+)")) {
                String name = update.message().text();
                String[] newName = name.split(" ");
                String firstName = newName[0];
                String lastName = newName[1];
                if (service.searchUserName(firstName, lastName) == true &&
                        service.addRuleForName(firstName, lastName) != null) {
                    var rule = service.addRuleForName(firstName, lastName);
                    for (Recommendations recommendations : rule) {

                        SendMessage message = new SendMessage(id, "/recommend " + firstName + " " + lastName + "\n" +
                                recommendations.getUseId().toString() + "\n" +
                                recommendations.getProductName() + "\n" +
                                recommendations.getProductText() + "\n\n" +
                                recommendations.getRequests().get(0).getQuery() + "\n" +
                                recommendations.getRequests().get(0).getArguments() + "\n" +
                                service.newNegate(recommendations.getRequests().get(0).getNegate()) + "\n\n" +
                                recommendations.getRequests().get(1).getQuery() + "\n" +
                                recommendations.getRequests().get(1).getArguments() + "\n" +
                                service.newNegate(recommendations.getRequests().get(1).getNegate()) + "\n\n" +
                                recommendations.getRequests().get(2).getQuery() + "\n" +
                                recommendations.getRequests().get(2).getArguments() + "\n" +
                                service.newNegate(recommendations.getRequests().get(2).getNegate()) + "\n\n");

                        SendResponse response = telegramBot.execute(message);
                    }


                } else {
                    SendMessage message = new SendMessage(id, "нет такого имени");
                    SendResponse response = telegramBot.execute(message);
                }

            } else {
                SendMessage message2 = new SendMessage(id, "No Ok  ");
                SendResponse response2 = telegramBot.execute(message2);
            }

        });

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}