package _04_dsl_frontend_backend.pages

import _04_dsl_frontend_backend.Product
import _04_dsl_frontend_backend.backend.getProducts
import _04_dsl_frontend_backend.click
import _04_dsl_frontend_backend.on
import dev.kolibrium.core.selenium.cssSelector
import dev.kolibrium.core.selenium.cssSelectors
import io.kotest.matchers.shouldBe
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

context(WebDriver)
class ProductsPage {
    private val shoppingCartBadge by cssSelectors("span[class='bag__quantity']")

    private val products by lazy {
        getProducts().products
    }

    fun Product.addToCart() {
        val id = findProductId()
        val root by cssSelector("div[id='$id']")
        val item = Item(root, id)
        click on item.addToCartButton
    }

    fun verifyShoppingCartBadgeIs(count: Int) {
        shoppingCartBadge.first().text shouldBe count.toString()
    }

    private fun Product.findProductId() = products.first { product ->
        product.description == displayName
    }.id
}

private class Item(root: WebElement, indexOfProduct: Int) {
    val addToCartButton by root.cssSelector(
        value = "div[id='$indexOfProduct'] div[class='shelf-item__buy-btn']"
    )
}
