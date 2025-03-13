package _02_lazy_delegate

import BaseTest
import com.titusfortner.logging.SeleniumLogger
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Lazy property delegate.
 */
class LazyDelegateTest : BaseTest("https://www.saucedemo.com") {
    companion object {
        @JvmStatic
        @BeforeAll
        fun enableLogging() {
            SeleniumLogger.enable("RemoteWebDriver")
        }
    }

    @Test
    fun `using lazy property delegate for element caching`() {
        LoginPage(driver).login(username = "standard_user", password = "secret_sauce")

        with(InventoryPage(driver)) {
            titleText() shouldBe "Products"
            titleText() shouldBe "Products"
            titleText() shouldBe "Products"
        }
    }
}

