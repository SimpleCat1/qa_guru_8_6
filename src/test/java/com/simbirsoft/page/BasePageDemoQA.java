package com.simbirsoft.page;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BasePageDemoQA {
    @BeforeAll
    public static void helperDriver() {
        Configuration.startMaximized = true;
        Configuration.browser = "Firefox";
    }
}
