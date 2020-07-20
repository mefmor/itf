package net.mefmor.itf;


import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

    @LocalServerPort
    private int port;
    private static HtmlUnitDriver browser;

    @BeforeClass
    public static void setup() {
        browser = new HtmlUnitDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void teardown() {
        browser.quit();
    }

    @Test
    public void testHomePage() {
        String homePage = "http://localhost:" + port;
        browser.get(homePage);

        assertThat(browser.getTitle()).isEqualTo("Integration Testing Framework");
        assertThat(browser.findElementByTagName("h1").getText()).isEqualTo("Welcome to...");
        assertThat(browser.findElementByTagName("img").getAttribute("src"))
                .isEqualTo(homePage + "/images/InTestWeTrust.png");
    }

}
