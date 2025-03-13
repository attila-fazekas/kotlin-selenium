package _03_custom_property_delegate

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import kotlin.properties.ReadOnlyProperty

fun WebDriver.className(value: String): ReadOnlyProperty<Any, WebElement> =
    ReadOnlyProperty { _, _ -> findElement(By.className(value)) }

fun WebDriver.cssSelector(value: String): ReadOnlyProperty<Any, WebElement> =
    ReadOnlyProperty { _, _ -> findElement(By.cssSelector(value)) }

fun WebDriver.id(value: String): ReadOnlyProperty<Any, WebElement> =
    ReadOnlyProperty { _, _ -> findElement(By.id(value)) }

fun WebDriver.name(value: String): ReadOnlyProperty<Any, WebElement> = ReadOnlyProperty { _, _ ->
    findElement(By.name(value))
}
