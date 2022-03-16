package com.severstal;

import com.severstal.helpers.DriverConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SeverstalSiteTest extends DriverConfig {

    @Test
    @DisplayName("Проверка заголовка страницы")
    void testTitle() {
        step("Открыть страницу:", () -> {
            open("https://www.severstal.com");
        });

        step("Проверить title открытой страницы:", () -> {
            $("title").shouldHave(attribute("text", "Северсталь"));
        });
    }

    @Test
    @DisplayName("Проверить страницу 'О компании'")
    void testAbout() {
        step("Открыть страницу:", () -> {
            open("https://www.severstal.com");
        });

        step("Перейти на страницу:", () -> {
            $("[href='/rus/about/']").click();
        });

        step("Проверить title открытой страницы:", () -> {
            $("title").shouldHave(attribute("text", "Северсталь - О компании"));
        });

        step("Проверить текст в блоке 'intro':", () -> {
            $(".intro").shouldBe(text("ПАО «Северсталь» — это вертикально интегрированная горнодобывающая и металлургическая " +
                    "компания с основными активами в России и небольшим количеством предприятий за рубежом."));
        });
    }

    @Test
    @DisplayName("Проверить страницу 'Контакты'")
    void testContacts() {
        step("Открыть страницу:", () -> {
            open("https://www.severstal.com");
        });

        step("Перейти на страницу:", () -> {
            $("[href='/rus/global_contacts/']").click();
        });

        step("Проверить текст в блоке 'Головной офис ПАО Северсталь':", () -> {
            $(".info").shouldHave(
                    text("ул. Клары Цеткин, 2, Москва, Россия, 127299"),
                    text("+7 (495) 926 77 66"),
                    text("+7 (495) 926 77 66"),
                    text("Юридический адрес: ул. Мира 30, Череповец, Вологодская обл., Россия, 162608"),
                    text("Почтовый адрес: 127299, Россия, Москва, ул. Клары Цеткин 2"),
                    text("+7 (8202) 53 0900"),
                    text("+7 (8202) 53 0915"),
                    text("severstal@severstal.com")
            );
        });
    }

}