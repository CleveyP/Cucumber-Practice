package org.example.steps;


import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetAuthFormPage;
import org.example.pages.TheInternetPage;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class InternetAuthFormSteps {
    private final InternetAuthFormPage page;
    private final WebDriverWait wait;
    private final GenericSteps genericSteps;

    @And("the user enters their username {string} and password {string}")
    public void and_the_user_enters_their_username_and_password(String username, String password) {
        page.fillAuthenticationForm(username, password);
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        page.submitAuthenticationForm();
    }

    @And("the user clicks the {string} button")
    public void the_user_clicks_the_auth_button(String buttonLabel) {
        genericSteps.clickLinkOrButton(buttonLabel);
    }

    @And("a banner shows the reject text: {string}")
    public void a_banner_shows_the_reject_text(String rejectText) {
        page.assertAuthBannerText(rejectText);
    }
}
