package _01_basic_pom

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class InventoryPage(private val driver: WebDriver) {
    private val title = By.className("title")

    fun titleText() = driver.findElement(title).text
}