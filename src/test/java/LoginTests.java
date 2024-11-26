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
    @Test
    void negativeLoginTest(){
        open("https://qa-practice.netlify.app");
        $("[id=auth-shop]").click();
        $("[id=\"email\"]").setValue("test@test.com");
        $("[id=\"password\"]").setValue("test123");
        $("[id=\"submitLoginBtn\"]").click();
        $("[class=\"alert alert-danger\"]").shouldHave(text("Bad credentials! Please try again! Make sure that you've registered."));
    }
    //empty login test not possible due to website not having a separate notification for empty login fields
}
