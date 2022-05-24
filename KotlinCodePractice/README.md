# Kotlin 101 practice
## How to create a kotlin project IntelliJ IDEA
* click **File** -> **New** -> **Kotlin**, IDEA will help to create kotlin project with JVM
* You also can use REPL (Read-Eval-Print-Loop) interactive shell to practice the basic kotlin syntax
## Kotlin basic syntax
* Kotlin is very similar to java language, but also there is several difficulties between them.
  * using ```fun``` to define a function
  * no semicolons in the end of a line
  * using parentheses for function arguments
  * using curly brace to define function block
* Syntax
  * operator ```var``` and ```val```, var is for mutable definition, val is for immutable definition.
  * define variable type: ```var rocks: Int = 1```, type is behind the variable and divided by colon.
  * nullability
    * using operator ```?``` to define a nullable variable
    * using operator ```!!``` to make a not-null announcement
  * list
    * listOf is immutable
    * mutableListOf is mutable
  * array: create array by build-in function ```arrayOf```
  * loop
    * do/ while
    * foreach
    * repeat
      ```kotlin
        repeat(2) {
           println("A fish is swimming")
        }
      ```
  * function
    * without return value
    ```kotlin
    fun feedTheFish() {
       println("test")
    }
    ```
    * with return value
    ```kotlin
    fun feedTheFishWithValue(): String {
       val test = "test string"
       return test 
    }
    ```
    * default value of parameter
    ```kotlin
    fun functionWithDefaultValueArgument(speed: String = "test speed") {
        println("test argument value $speed")
    }
    ```
    * lambdas
    * higher-order-functions: passing a lambda to another function