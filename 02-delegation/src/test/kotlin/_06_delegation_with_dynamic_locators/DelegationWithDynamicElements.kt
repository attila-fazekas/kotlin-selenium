package _06_delegation_with_dynamic_locators

import BaseTest
import _06_delegation_with_dynamic_locators.Product.IPHONE_12
import _06_delegation_with_dynamic_locators.Product.IPHONE_12_MINI
import org.junit.jupiter.api.Test

/**
 * Delegation with dynamic locators.
 */
class DelegationWithDynamicElements : BaseTest("https://bstackdemo.com") {
    @Test
    fun `using custom property delegate with dynamic locators`() {
        with(ProductsPage(driver)) {
            val products = listOf(IPHONE_12, IPHONE_12_MINI)

            products.forEach { product ->
                product.addToCart()
            }

            verifyShoppingCartBadgeIs(products.size)
        }
    }
}