package _03_dsl_cookies

import BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Bypass the login by injecting a cookie with credentials into the browser.
 */
class BypassLoginTest : BaseTest() {
    @Test
    fun `setting cookies to bypass login`() {
        inventoryPage {
            titleText() shouldBe "Products"
        }
    }

    private fun inventoryPage(bypassLogin: Boolean = true, block: InventoryPage.() -> Unit) {
        with(driver) {
            InventoryPage(bypassLogin).apply(block)
        }
    }
}
