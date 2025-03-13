package _04_delegation_with_synchronization

import BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Custom property delegate with synchronization.
 */
class DelegationWithSynchronizationTest : BaseTest("pages/delayed_enabled_button.html", isOnFileSystem = true) {
    @Test
    fun `using custom property delegate with synchronization for element lookup`() {
        with(ButtonPage(driver)) {
            clickButton()

            message() shouldBe "Button clicked!"
        }
    }
}
