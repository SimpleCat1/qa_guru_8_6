package com.simbirsoft.tests;

import com.simbirsoft.data.GithubPageData;
import com.simbirsoft.page.BasePageDemoQA;
import com.simbirsoft.page.PageDemoQALambdaSteps;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GithubPageLambdaTests extends BasePageDemoQA {
    PageDemoQALambdaSteps step = new PageDemoQALambdaSteps();
    GithubPageData data = new GithubPageData();

    @Test
    @DisplayName("Проверка номера Isseus в репозитории")
    public void LookForIssuesLambdaSteps() {
        Allure.feature("Issue");
        Allure.story("Поиск номера в Issue");
        Allure.label("owner", "SimplePerson");
        Allure.label("severity", SeverityLevel.CRITICAL.toString());
        Allure.description("Ищем репозиторий , а потом в нем смотрим номер любой, что есть под одной хотя бы записью");

        step.openPageLambda(data.url);
        step.clickOnLocatorLambda(data.inputSearch).inputWordsLambda(data.inputSearch, data.textForSearch);
        step.clickOnLocatorLambda(data.hrefRepository);
        step.clickOnLocatorLambda(data.elementIssues);
        step.checkTextLocator(data.numberIssues, data.textIssues);
    }
}
