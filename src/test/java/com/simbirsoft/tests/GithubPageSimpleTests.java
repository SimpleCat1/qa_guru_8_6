package com.simbirsoft.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.data.GithubPageData;
import com.simbirsoft.page.BasePageDemoQA;
import com.simbirsoft.page.PageDemoQASteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GithubPageSimpleTests extends BasePageDemoQA {
    GithubPageData data = new GithubPageData();

    @Test
    public void LookForIssuesPageSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(data.url);
        $(data.inputSearch).setValue(data.textForSearch).pressEnter();
        $(data.hrefRepository).click();
        $(data.elementIssues).click();
        new PageDemoQASteps().checkTextLocator(data.numberIssues, data.textIssues);
    }
}
