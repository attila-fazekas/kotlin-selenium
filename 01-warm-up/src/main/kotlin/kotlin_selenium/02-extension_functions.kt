package kotlin_selenium

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

/**
 * Extension functions.
 */
fun WebDriver.open(url: String) = this.get(url)

fun WebElement.type(text: String) = this.sendKeys(text)

fun main() {
    val driver = ChromeDriver()
    driver.open("https://www.selenium.dev/documentation")

    val searchField = driver.findElement(By.className("DocSearch-Button-Placeholder"))
    searchField.click()

    val searchText = driver.findElement(By.className("DocSearch-Input"))
    searchText.type("page object")

    driver.quit()
}