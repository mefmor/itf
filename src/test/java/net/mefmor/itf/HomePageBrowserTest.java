package net.mefmor.itf;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomePageBrowserTest {

    @LocalServerPort
    private int port;
    private static HtmlUnitDriver browser;

    @BeforeAll
    static void setup() {
        browser = new HtmlUnitDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    static void teardown() {
        browser.quit();
    }

    @Test
    void testHomePage() {
        String homePage = "http://localhost:" + port;
        browser.get(homePage);

        assertThat(browser.getTitle()).isEqualTo("Integration Testing Framework");
        assertThat(browser.findElementByTagName("h1").getText()).isEqualTo("Welcome to...");
        assertThat(browser.findElementByTagName("img").getAttribute("src"))
                .isEqualTo(homePage + "/images/InTestWeTrust.png");
    }

}
