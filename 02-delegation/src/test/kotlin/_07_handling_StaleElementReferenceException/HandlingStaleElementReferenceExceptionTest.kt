package _07_handling_StaleElementReferenceException

import BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Relocating elements when StaleElementReferenceException occurs.
 */
class HandlingStaleElementReferenceExceptionTest :
    BaseTest("pages/stale_button.html", isOnFileSystem = true) {
    @Test
    fun `handling StaleElementReferenceException`() {
        with(ButtonPage(driver)) {
            clickButton()

            message() shouldBe "Button clicked!"
        }
    }
}
