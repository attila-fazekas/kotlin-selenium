package kotlin_selenium.scope_functions

import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration.ofMillis

/**
 * with: performing multiple operations on the same object.
 */
fun setupDriverWith(): ChromeDriver {
    val driver = ChromeDriver()
    with(driver) {
        manage().window().maximize()
        manage().timeouts().pageLoadTimeout(ofMillis(500))
        manage().timeouts().scriptTimeout(ofMillis(250))
        get("https://kotlinlang.org")
    }
    return driver
}
