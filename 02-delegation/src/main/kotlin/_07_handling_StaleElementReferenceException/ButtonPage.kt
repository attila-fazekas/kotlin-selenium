package _07_handling_StaleElementReferenceException

import dev.kolibrium.core.selenium.id
import org.openqa.selenium.WebDriver

/**
 * Relocates element when StaleElementReferenceException occurs.
 */
class ButtonPage(driver: WebDriver) {
    private val button by driver.id("myButton") {
        isEnabled
    }

    private val message by driver.id("message")

    fun clickButton() {
        button.click()
    }

    fun message() = message.text
}
