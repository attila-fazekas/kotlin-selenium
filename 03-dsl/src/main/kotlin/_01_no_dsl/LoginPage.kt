package _01_no_dsl

import dev.kolibrium.core.selenium.idOrName
import dev.kolibrium.core.selenium.name
import org.openqa.selenium.WebDriver

/**
 * To model the user’s journey through our application,
 * methods on the page object should return other page objects:
 * https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/#implementation-notes
 */
context(WebDriver)
class LoginPage {
    private val usernameInput by name("user-name")
    private val passwordInput by idOrName("password")
    private val loginButton by name("login-button")

    fun login(username: String = "standard_user", password: String = "secret_sauce"): InventoryPage {
        usernameInput.sendKeys(username)
        passwordInput.sendKeys(password)
        loginButton.click()

        return InventoryPage()
    }
}
