import decorators.HighlighterDecorator
import decorators.SlowMotionDecorator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.nio.file.Paths

open class BaseTest(private val url: String, private val isOnFileSystem: Boolean = false) {
    protected lateinit var driver: WebDriver

    @BeforeEach
    open fun setUp() {
        driver = SlowMotionDecorator
            .decorate(HighlighterDecorator.decorate(ChromeDriver())) as WebDriver
        val url  = if (isOnFileSystem) {
            val absolutePath = Paths.get("").toAbsolutePath().parent.resolve(url)
            "file:////$absolutePath"
        } else {
            url
        }
        driver.get(url)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}