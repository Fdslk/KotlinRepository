fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    printHello()

    testArgumentFunction()

    testLamdbaFunction(10)
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
}

