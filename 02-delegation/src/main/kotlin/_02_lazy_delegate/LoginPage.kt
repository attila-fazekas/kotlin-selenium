package _02_lazy_delegate

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * Lazy property delegate.
 */
class LoginPage(driver: WebDriver) {
    private val usernameInput by lazy {
        driver.findElement(By.name("user-name"))
    }

    private val passwordInput by lazy {
        driver.findElement(By.name("password"))
    }

    private val loginButton by lazy {
        driver.findElement(By.name("login-button"))
    }

    fun login(username: String, password: String) {
        usernameInput.sendKeys(username)
        passwordInput.sendKeys(password)
        loginButton.click()
    }
}
