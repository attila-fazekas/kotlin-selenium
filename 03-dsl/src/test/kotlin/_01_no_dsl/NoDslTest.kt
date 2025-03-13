package _01_no_dsl

import BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NoDslTest : BaseTest() {
    @Test
    fun testLogin() {
        with(driver) {
            val inventoryPage = LoginPage().login()

            inventoryPage.titleText() shouldBe "Products"
        }
    }
}
