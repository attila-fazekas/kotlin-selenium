package _06_delegation_with_dynamic_locators

import dev.kolibrium.core.selenium.cssSelector
import dev.kolibrium.core.selenium.cssSelectors
import io.kotest.matchers.shouldBe
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Page Component Object implementation:
 * https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/#page-component-objects
 */
class ProductsPage(val driver: WebDriver) {
    private val shoppingCartBadge by driver.cssSelectors("span[class='bag__quantity']")

    fun Product.addToCart() {
        val root by driver.cssSelector("div[id='${index}']")
        val item = Item(root, index)
        item.addToCartButton.click()
    }

    fun verifyShoppingCartBadgeIs(count: Int) {
        shoppingCartBadge.first().text shouldBe count.toString()
    }
}

private class Item(root: WebElement, indexOfProduct: Int) {
    val addToCartButton by root.cssSelector(
        value = "div[id='$indexOfProduct'] div[class='shelf-item__buy-btn']"
    )
}