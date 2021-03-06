package example.annotation
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@Target(AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false


    @OnGet fun trim(){}
    fun fertilize(){}
}

fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.declaredMemberFunctions) {
        if(m.findAnnotation<OnGet>() != null && m.findAnnotation<OnGet>()!!.annotationClass == OnGet::class){
            println("Yeah, '${m.name}()' you are my target annotation.")
        }

        println(m.name)
    }

    for (m in classObj.annotations) {
        println(m.annotationClass.simpleName)
    }

    println(classObj.findAnnotation<ImAPlant>())
}

fun labels() {
    outRule@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outRule // breaks to outer loop
        }
    }
}

fun main() {
//    testAnnotations()
    labels()
}

annotation class ImAPlant
