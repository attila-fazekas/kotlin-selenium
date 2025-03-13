package _04_dsl_frontend_backend

import _04_dsl_frontend_backend.Product.IPHONE_12
import _04_dsl_frontend_backend.Product.IPHONE_12_MINI
import _04_dsl_frontend_backend.pages.ProductsPage
import decorators.HighlighterDecorator
import decorators.SlowMotionDecorator
import dev.kolibrium.dsl.selenium.creation.Arguments.Chrome.disable_search_engine_choice_screen
import dev.kolibrium.dsl.selenium.creation.Arguments.Chrome.incognito
import dev.kolibrium.dsl.selenium.creation.chromeDriver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver

/**
 * DslMarker annotation for syntax highlighting frontend and backend APIs.
 */
class BrowserStackTest {
    private lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        val chromeDriver = chromeDriver {
            options {
                arguments {
                    +disable_search_engine_choice_screen
                    +incognito
                }
            }
        }

        driver = (SlowMotionDecorator.decorate(HighlighterDecorator.decorate(chromeDriver)) as WebDriver).apply {
            get("https://bstackdemo.com")
        }
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun `add products to the cart`() {
        val products = listOf(IPHONE_12, IPHONE_12_MINI)

        productsPage {
            products.forEach { product ->
                product.addToCart()
            }

            verifyShoppingCartBadgeIs(products.size)
        }
    }

    @FrontendDsl
    private fun productsPage(block: ProductsPage.() -> Unit) {
        with(driver) {
            ProductsPage().apply(block)
        }
    }
}
