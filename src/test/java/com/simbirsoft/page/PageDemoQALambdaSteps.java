package com.simbirsoft.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PageDemoQALambdaSteps {

    public PageDemoQALambdaSteps clickOnLocatorLambda(SelenideElement locator) {
        step("Наводит на элемент " + locator + " и нажимаем", () -> {
            locator.scrollTo().click();
        });
        return new PageDemoQALambdaSteps();
    }

    public void inputWordsLambda(SelenideElement locator, String text) {
        step("Ввод текста " + text + " в локатор " + locator + " и нажимаем enter", () -> {
            locator.setValue(text).pressEnter();
        });
    }

    public void openPageLambda(String text) {
        step("Отркрываем страницу " + text, () -> {
            open(text);
        });
    }

    public void checkTextLocator(String locator, String text) {
        step("Проверяем частичное совпадение текста {text} у элемента {locator}", () -> {
            $$(locator).findBy(text(text)).shouldHave(text(text));
        });
    }
}
