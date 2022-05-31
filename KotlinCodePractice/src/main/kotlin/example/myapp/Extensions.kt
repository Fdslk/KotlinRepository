package example.myapp

class Extensions(name: String, age: Int, gender: String)  {
    val name = name
    val age = age
    val gender = gender

    fun printPerson() {
        println(name)
        println(age)
        println(gender)
    }
}

fun Extensions.hasShortName(len: Int = 3): Boolean {
    return this.name.length <= len
}

fun Extensions.hasOldAge(limit: Int = 20): Boolean = this.age  >= limit