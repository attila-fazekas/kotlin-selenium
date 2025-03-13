package decorators

import decorators.BorderStyle.SOLID
import decorators.Color.RED
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

private const val MIN = 1
private const val MAX = 20

object HighlighterDecorator : AbstractDecorator() {
    private class Config(
        val style: BorderStyle = SOLID,
        val color: Color = RED,
        val width: Int = 5,
    ) {
        init {
            require(width in MIN..MAX) { "width must be between $MIN and $MAX." }
        }
    }

    private val config = ThreadLocal.withInitial { Config() }

    fun configure(
        style: BorderStyle = SOLID,
        color: Color = RED,
        width: Int = 5,
    ): HighlighterDecorator {
        config.set(Config(style, color, width))
        return this
    }

    override fun decorateDriver(driver: WebDriver): WebDriver {
        return object : WebDriver by driver {
            override fun findElement(by: By): WebElement {
                val element = driver.findElement(by)
                element.highlightElement()
                return decorateElement(element)
            }

            override fun findElements(by: By): List<WebElement> =
                driver.findElements(by).map { element ->
                    element.highlightElement()
                    decorateElement(element)
                }
        }
    }

    override fun decorateElement(element: WebElement): WebElement {
        return object : WebElement by element {
            override fun findElement(by: By): WebElement {
                val foundElement = element.findElement(by)
                foundElement.highlightElement()
                return decorateElement(foundElement)
            }

            override fun findElements(by: By): List<WebElement> =
                element.findElements(by).map { foundElement ->
                    foundElement.highlightElement()
                    decorateElement(foundElement)
                }
        }
    }

    private fun WebElement.highlightElement() {
        val currentConfig = config.get()
        try {
            val driver =
                when (this) {
                    is RemoteWebElement -> wrappedDriver
                    else -> null
                } ?: return

            (driver as JavascriptExecutor).executeScript(
                """
                const elements = document.querySelectorAll('[style*="border"]');
                elements.forEach(el => el.style.removeProperty('border'));
                arguments[0].style.border = '${currentConfig.style.name.lowercase()} ${currentConfig.color.name.lowercase()} ${currentConfig.width}px';
                """.trimIndent(),
                this,
            )
        } catch (e: Exception) {
            println( "Failed to highlight element: ${e.message}" )
        }
    }
}

public enum class BorderStyle {
    DASHED,

    DOTTED,

    SOLID,
}

public enum class Color {
    BLACK,
    BLUE,
    GRAY,
    GREEN,
    ORANGE,
    PINK,
    PURPLE,
    RED,
    YELLOW,
    WHITE,
}