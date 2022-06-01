package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PageDemoQASteps {

    @Step("Наводит на элемент {locator} и нажимаем")
    public PageDemoQASteps clickOnLocator(SelenideElement locator) {
        locator.scrollTo().click();
        return new PageDemoQASteps();
    }

    @Step("Ввод текста {text} в локатор {locator} и нажимаем enter")
    public void inputWords(SelenideElement locator, String text) {
        locator.setValue(text).pressEnter();
    }

    @Step("Отркрываем страницу {text}")
    public void openPage(String text) {
        open(text);
    }

    public PageDemoQASteps clickOnLocatorLambda(SelenideElement locator) {
        step("Наводит на элемент {locator} и нажимаем", () -> {
            locator.scrollTo().click();
        });
        return new PageDemoQASteps();
    }

    @Step("Проверяем частичное совпадение текста {text} у элемента {locator}")
    public void checkTextLocator(String locator, String text) {
        //Перенес методы проверки в класс шагов для страницы, это рекомендация...
//        $x(String.format(locator, text)).shouldHave(text(text)); это использовать если xpath
        $$(locator).findBy(text(text)).shouldHave(text(text));
    }
}
