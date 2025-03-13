package kotlin_selenium.scope_functions

import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration.ofMillis

/**
 * apply: initializing and configuring objects.
 */
fun setupDriverApply() = ChromeDriver().apply {
    manage().window().maximize()
    manage().timeouts().pageLoadTimeout(ofMillis(500))
    manage().timeouts().scriptTimeout(ofMillis(250))
    get("https://kotlinlang.org")
}
