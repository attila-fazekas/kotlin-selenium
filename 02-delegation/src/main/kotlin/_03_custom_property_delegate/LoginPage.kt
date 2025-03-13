package _03_custom_property_delegate

import org.openqa.selenium.WebDriver

/**
 * Custom property delegate.
 */
class LoginPage(driver: WebDriver) {
    private val usernameInput by driver.name("user-name")
    private val passwordInput by driver.name("password")
    private val loginButton by driver.name("login-button")

    fun login(username: String, password: String) {
        usernameInput.sendKeys(username)
        passwordInput.sendKeys(password)
        loginButton.click()
    }
}
