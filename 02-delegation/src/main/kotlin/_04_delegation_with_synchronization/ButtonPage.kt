package _04_delegation_with_synchronization

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration
import kotlin.properties.ReadOnlyProperty

/**
 * Custom property delegate with synchronization.
 */
class ButtonPage(driver: WebDriver) {
    // remove the comment and the test will pass
    private val button by driver.id("button") // { isDisplayed }

    private val message by driver.id("message")

    fun clickButton() {
        button.click()
    }

    fun message() = message.text
}

fun WebDriver.id(value: String): ReadOnlyProperty<Any, WebElement> =
    ReadOnlyProperty { _, _ ->
        findElement(By.id(value))
    }

fun WebDriver.id(value: String, readyCondition: WebElement.() -> Boolean): ReadOnlyProperty<Any, WebElement> =
    ReadOnlyProperty { _, _ ->
        val wait = FluentWait(this).pollingEvery(Duration.ofMillis(250))
            .withTimeout(Duration.ofSeconds(5))

        wait.until {
            val element = findElement(By.id(value))
            readyCondition(element)
        }

        findElement(By.id(value))
    }