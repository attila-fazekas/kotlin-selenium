package _08_page_objects_with_context_receivers

import BaseTest
import org.junit.jupiter.api.Test

/**
 * Using context receivers to inject the driver dependency into POMs.
 */
class DelegationPageObjectWithContextReceiversTest : BaseTest("https://www.saucedemo.com") {
    @Test
    fun `using context receivers to inject driver instance to page object`() {
        with(driver) {
            LoginPage().login(username = "standard_user", password = "secret_sauce")
        }
    }
}