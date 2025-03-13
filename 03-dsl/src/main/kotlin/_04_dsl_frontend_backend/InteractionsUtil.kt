package _04_dsl_frontend_backend

import org.openqa.selenium.WebElement

fun type(
    block: TypeScope.() -> Unit,
) = TypeScope().apply(block)

class TypeScope {
    infix fun String.into(element: WebElement) {
        element.sendKeys(this)
    }
}

object click

infix fun click.on(element: WebElement) {
    element.click()
}