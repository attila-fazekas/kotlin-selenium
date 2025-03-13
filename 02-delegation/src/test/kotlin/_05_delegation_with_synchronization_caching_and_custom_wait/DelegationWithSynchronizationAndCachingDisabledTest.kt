package _05_delegation_with_synchronization_caching_and_custom_wait

import BaseTest
import com.titusfortner.logging.SeleniumLogger
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Delegation with synchronization, custom wait config and caching disabled.
 */
class DelegationWithSynchronizationAndCachingDisabledTest : BaseTest("pages/images.html", isOnFileSystem = true) {
    companion object {
        @JvmStatic
        @BeforeAll
        fun enableLogging() {
            SeleniumLogger.enable("RemoteWebDriver")
        }
    }

    @Test
    fun `using custom property delegate with synchronization and caching disabled`() {
        ImagesPage(driver).images.forEachIndexed { index, element ->
            element.getAttribute("alt") shouldBe "kodee$index"
        }
    }
}