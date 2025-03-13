package decorators

import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public abstract class AbstractDecorator {
    public fun decorate(context: SearchContext): SearchContext =
        when (context) {
            is WebDriver -> decorateDriver(context)
            is WebElement -> decorateElement(context)
            else -> context
        }

    internal abstract fun decorateDriver(driver: WebDriver): WebDriver

    internal abstract fun decorateElement(element: WebElement): WebElement
}