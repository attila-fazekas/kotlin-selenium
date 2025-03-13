import decorators.HighlighterDecorator
import decorators.SlowMotionDecorator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

open class BaseTest {
    protected lateinit var driver: WebDriver

    @BeforeEach
    open fun setUp() {
        driver = SlowMotionDecorator
            .decorate(HighlighterDecorator.decorate(ChromeDriver())) as WebDriver
        driver.get("https://www.saucedemo.com")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}