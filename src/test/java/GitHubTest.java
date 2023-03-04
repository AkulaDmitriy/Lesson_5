import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void solutionsEnterpriseTest(){
        open(Configuration.baseUrl);
        $x("//ul[@class='d-lg-flex list-style-none']/li[2]/button").hover();
        $x("//a[contains(@class,'HeaderMenu-dropdown-link') and @href='/enterprise']").hover().click();
        $x("//h1[contains(@class,'mb-3')]").shouldHave(text("Build like the best"));

    }
    @Test
    void dragDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
