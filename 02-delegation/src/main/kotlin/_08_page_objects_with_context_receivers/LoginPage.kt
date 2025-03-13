package _08_page_objects_with_context_receivers

import dev.kolibrium.core.selenium.id
import org.openqa.selenium.WebDriver

/**
 * Using context receivers to inject driver dependency.
 */
context(WebDriver)
class LoginPage {
    private val usernameInput by id("user-name")
    private val passwordInput by id("password")
    private val loginButton by id("login-button")

    fun login(username: String, password: String) {
        usernameInput.sendKeys(username)
        passwordInput.sendKeys(password)
        loginButton.click()
    }
}