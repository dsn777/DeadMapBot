package com.dsn.DeadMapBot.bot.util;

import com.dsn.DeadMapBot.dto.DeadDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextFormatter {

    public static String getFormattedDead(DeadDto deadDto) {
        return bold("Фамилия: ") + deadDto.getLastname() + "\n" +
                bold("Имя: ") + deadDto.getFirstname() + "\n" +
                bold("Отчество: ") + deadDto.getMiddlename() + "\n" +
                bold("Дата рождения: ") + formatDate(deadDto.getBirthdate()) + "\n" +
                bold("Дата смерти: ") + formatDate(deadDto.getDeathdate()) + "\n" +
                bold("Могила: ") + link("точка на карте",
                "https://yandex.ru/maps/?whatshere[point]=" + deadDto.getLongitude() +  "," + deadDto.getLatitude() + "&whatshere[zoom]=17");
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return date.format(outputFormatter);
    }

    public static String bold(String str) {
        return "<b>" + str + "</b>";
    }

    public static String link(String str) {
        return "<a>" + str + "</a>";
    }

    public static String mono(String str) {
        return "<pre>" + str + "</pre>";
    }

    public static String link(String str, String url) {
        return "<a href=\"" + url + "\">" + str + "</a>";
    }

    public static String italic(String str) {
        return "<i>" + str + "</i>";
    }
}
