package _03_dsl_cookies

import dev.kolibrium.core.selenium.className
import dev.kolibrium.dsl.selenium.interactions.cookies
import dev.kolibrium.dsl.selenium.interactions.navigateTo
import org.openqa.selenium.WebDriver

/**
 * DSL for adding cookie with credentials to bypass login.
 */
context(WebDriver)
class InventoryPage(bypassLogin: Boolean = true) {
    private val title by className("title")

    init {
        if (bypassLogin) {
            cookies {
                addCookie(name = "session-username", value = "standard_user")
            }.apply {
                navigateTo("inventory.html")
            }
        }
    }

    fun titleText(): String = title.text
}