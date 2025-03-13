package kotlin_selenium.scope_functions

import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration.ofMillis

fun setupDriver(): ChromeDriver {
    val driver = ChromeDriver()
    driver.manage().window().maximize()
    driver.manage().timeouts().pageLoadTimeout(ofMillis(500))
    driver.manage().timeouts().scriptTimeout(ofMillis(250))
    driver.get("https://kotlinlang.org")
    return driver
}