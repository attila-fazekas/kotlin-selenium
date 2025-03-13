package _03_custom_property_delegate

import org.openqa.selenium.WebDriver

/**
 * Custom property delegate.
 */
class InventoryPage(driver: WebDriver) {
    private val title by driver.className("title")

    fun titleText(): String = title.text
}