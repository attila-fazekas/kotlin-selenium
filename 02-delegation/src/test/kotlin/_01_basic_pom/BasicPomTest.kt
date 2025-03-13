package _01_basic_pom

import BaseTest
import com.titusfortner.logging.SeleniumLogger
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class BasicPomTest : BaseTest("https://www.saucedemo.com") {
    companion object {
        @JvmStatic
        @BeforeAll
        fun enableLogging() {
            SeleniumLogger.enable("RemoteWebDriver")
        }
    }

    @Test
    fun testLogin() {
        LoginPage(driver).login(username = "standard_user", password = "secret_sauce")

        val inventoryPage = InventoryPage(driver)

        inventoryPage.titleText() shouldBe "Products"
    }
}