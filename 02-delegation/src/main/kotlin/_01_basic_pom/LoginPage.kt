package _01_basic_pom

import org.openqa.selenium.By.name
import org.openqa.selenium.WebDriver

class LoginPage(private val driver: WebDriver) {
    private val usernameInput = name("user-name")
    private val passwordInput = name("password")
    private val loginButton = name("login-button")

    fun login(username: String, password: String) {
        driver.findElement(usernameInput).sendKeys(username)
        driver.findElement(passwordInput).sendKeys(password)
        driver.findElement(loginButton).click()
    }
}