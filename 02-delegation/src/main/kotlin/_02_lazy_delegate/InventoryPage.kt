package _02_lazy_delegate

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * Lazy property delegate.
 */
class InventoryPage(driver: WebDriver) {
    private val title by lazy {
        driver.findElement(By.className("title"))
    }

    fun titleText(): String = title.text
}