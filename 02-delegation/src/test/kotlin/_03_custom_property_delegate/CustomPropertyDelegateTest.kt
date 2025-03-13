package _03_custom_property_delegate

import BaseTest
import com.titusfortner.logging.SeleniumLogger
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Custom property delegate.
 */
class CustomPropertyDelegateTest : BaseTest("https://www.saucedemo.com") {
    companion object {
        @JvmStatic
        @BeforeAll
        fun enableLogging() {
            SeleniumLogger.enable("RemoteWebDriver")
        }
    }

    @Test
    fun `using custom property delegate for element lookup`() {
        LoginPage(driver).login(username = "standard_user", password = "secret_sauce")

        InventoryPage(driver).titleText() shouldBe "Products"
    }
}

