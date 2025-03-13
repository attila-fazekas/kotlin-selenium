package _01_no_dsl

import dev.kolibrium.core.selenium.className
import org.openqa.selenium.WebDriver

context(WebDriver)
class InventoryPage {
    private val title by className("title")

    fun titleText(): String = title.text
}