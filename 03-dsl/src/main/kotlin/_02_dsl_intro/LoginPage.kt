package _02_dsl_intro

import dev.kolibrium.core.selenium.idOrName
import dev.kolibrium.core.selenium.name
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * DSLs for typing and clicking.
 */
context(WebDriver)
class LoginPage {
    private val usernameField by name("user-name")
    private val passwordField by idOrName("password")
    private val loginButton by name("login-button")

    fun login(username: String = "standard_user", password: String = "secret_sauce"): InventoryPage {
        type {
            username into usernameField
            password into passwordField
        }

        click on loginButton

        return InventoryPage()
    }
}

fun type(block: TypeScope.() -> Unit) = TypeScope().apply(block)

class TypeScope {
    infix fun String.into(element: WebElement) {
        element.sendKeys(this)
    }
}

object click {
    infix fun on(element: WebElement) {
        element.click()
    }
}
