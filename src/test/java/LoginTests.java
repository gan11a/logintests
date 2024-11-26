import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    @Test
//make the test take credentials from the website itself
    void positiveLoginTest(){
        open("https://qa-practice.netlify.app");
        $("[id=auth-shop]").click();
        $("[id=\"email\"]").setValue("admin@admin.com");
        $("[id=\"password\"]").setValue("admin123");
        $("[id=\"submitLoginBtn\"]").click();
        $("[class=\"nav navbar-nav ml-auto\"]").shouldHave(text("Log Out"));
    }
}
