package _02_dsl_intro

import BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Using lambda with a receiver to interact with the POMs in a DSL-like style.
 */
class DslTest : BaseTest() {
    @Test
    fun testLogin() {
        loginPage {
            val inventoryPage = login()

            with(inventoryPage) {
                titleText() shouldBe "Products"
            }
        }
    }

    private fun loginPage(block: LoginPage.() -> Unit) {
        with(driver) {
            LoginPage().apply(block)
        }
    }
}
