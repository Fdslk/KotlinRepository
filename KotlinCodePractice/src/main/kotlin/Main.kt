import example.myapp.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    printHello()

    testArgumentFunction()

    testLamdbaFunction(10)

    val testHighOrderFunction = processIntTypeValue(1, toString)
    val testHighOrderFunction1 = processIntTypeValue(1) { str -> str.toString() }
    println(testHighOrderFunction)
    println(testHighOrderFunction1)
    println(calculate(1, 2, ::sum))
    println(processIntTypeValue(10, ::toStringRegular))
    println(calculate(10, 10, sum1))
    println(calculate(10, 10, sum2))

    buildAquarium()

    buildAquariumSub()

    val plecostomus = Plecostomus()
    println(plecostomus.color)
    plecostomus.eat()

    val blackPlecostomus = Plecostomus(fishColor = BlackColor)
    println(blackPlecostomus.color)
    blackPlecostomus.eat()

}
fun printHello() {
    var rocks: Int? = null
    var fishFoodTreats = 6
    if (fishFoodTreats != null) {
        fishFoodTreats = fishFoodTreats.dec()
        println(fishFoodTreats)
    }

    try {
        if (rocks!!.equals(1)) { // !! convert any value to a non-null type and throw an NullPointExceptions if the value is null
            println(rocks)
        }
    } catch (e: Exception) {
        println(e.message)
    }

    val listOf = listOf("test", "create", "list")
    println(listOf)

    listOf.map { x -> println(x) }
}

/*
 function with default parameter value
 */
fun testArgumentFunction(speed: String = "test") {
    println("test is value $speed");
}

fun testLamdbaFunction(divideValue: Int) {
    var simpleDividedFunc = { dirty : Int -> dirty / 2 }

    var simpleDividedFunc2: (Int) -> Int = { dirty -> dirty / 2 }

    println(simpleDividedFunc(divideValue))
    println(simpleDividedFunc2(divideValue))

    var upperCase2: (String) -> String = {str -> str.uppercase()}
    var upperCase3 = {str: String -> str.uppercase()}
    var upperCase4: (String) -> String = String::uppercase
}

var toString: (Int) -> String = {str: Int -> (str + 1).toString()}

fun toStringRegular(x: Int): String {
    return x.toString()
}

fun processIntTypeValue(testValue: Int, operator: (Int) -> String): String {
    return operator(testValue)
}

fun calculate(x: Int, y: Int, operator: (Int, Int) -> Int): Int{
    return operator(x, y)
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

var sum1: (Int, Int) -> Int = {num1, num2 -> (num1 + num2)}
var sum2 = {num1: Int, num2: Int -> (num1 + num2)}

fun operate(): (Int, Int) -> Int {
    return ::sum
}

fun operate2(): (Int, Int) -> Int {
    return sum1
}