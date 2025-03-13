package decorators

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.lang.Thread.sleep
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

object SlowMotionDecorator : AbstractDecorator() {
    private val waitDuration = ThreadLocal.withInitial { 1.seconds }

    fun configure(wait: Duration): SlowMotionDecorator {
        waitDuration.set(wait)
        return this
    }

    override fun decorateDriver(driver: WebDriver): WebDriver {
        return object : WebDriver by driver {
            override fun findElement(by: By): WebElement {
                val element = driver.findElement(by)
                addDelay()
                return decorateElement(element)
            }

            override fun findElements(by: By): List<WebElement> {
                val elements = driver.findElements(by)
                addDelay()
                return elements.map { element ->
                    decorateElement(element)
                }
            }
        }
    }

    override fun decorateElement(element: WebElement): WebElement {
        return object : WebElement by element {
            override fun findElement(by: By): WebElement {
                val foundElement = element.findElement(by)
                addDelay()
                return decorateElement(foundElement)
            }

            override fun findElements(by: By): List<WebElement> {
                val elements = element.findElements(by)
                addDelay()
                return elements.map { foundElement ->
                    decorateElement(foundElement)
                }
            }
        }
    }

    private fun addDelay() {
        try {
            sleep(waitDuration.get().toJavaDuration())
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}