package com.simbirsoft.tests;

import com.simbirsoft.data.GithubPageData;
import com.simbirsoft.page.BasePageDemoQA;
import com.simbirsoft.page.PageDemoQASteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GithubPageStepTests extends BasePageDemoQA {
    PageDemoQASteps step = new PageDemoQASteps();
    GithubPageData data = new GithubPageData();

    @Test
    @Feature("Issue")
    @Story("Поиск номера 66 в Issue")
    @Owner("SimplePerson")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка номера Isseus в репозитории")
    @Description("Ищем репозиторий , а потом в нем смотрим номер любой, что есть под одной хотя бы записью")
    public void LookForIssuesSelenideSteps() {
        step.openPage(data.url);
        step.clickOnLocator(data.inputSearch).inputWords(data.inputSearch, data.textForSearch);
        step.clickOnLocator(data.hrefRepository);
        step.clickOnLocator(data.elementIssues);
        step.checkTextLocator(data.numberIssues, data.textIssues);
    }
}
