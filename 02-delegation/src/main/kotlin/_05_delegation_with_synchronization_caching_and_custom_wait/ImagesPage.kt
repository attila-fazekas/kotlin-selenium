package _05_delegation_with_synchronization_caching_and_custom_wait

import dev.kolibrium.core.selenium.Wait.Companion.DEFAULT
import dev.kolibrium.core.selenium.names
import org.openqa.selenium.WebDriver
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Custom property delegate with synchronization, custom wait config and caching disabled.
 */
class ImagesPage(driver: WebDriver) {
    val images by driver.names(
        value = "kodee",
        cacheLookup = true, // set to false and the test will pass
        waitConfig = DEFAULT.copy(pollingInterval = 100.milliseconds, timeout = 3.seconds)
    ) {
        size == 9
    }
}
