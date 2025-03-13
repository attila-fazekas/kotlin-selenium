package _02_dsl_intro

import dev.kolibrium.core.selenium.className
import org.openqa.selenium.WebDriver

/**
 * Implement the invoke convention to be able to call a block on the inventoryPage variable in the test.
 */
context(WebDriver)
class InventoryPage {
    private val title by className("title")

    operator fun invoke(block: InventoryPage.() -> Unit) {
        block()
    }

    fun titleText(): String = title.text
}