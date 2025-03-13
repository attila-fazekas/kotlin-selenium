package kotlin_selenium

/**
 * Top level function.
 */
fun sayHello() {
    println("Hello")
}

/**
 * Single-expression function.
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    sayHello()
    sum(2, 3)
}