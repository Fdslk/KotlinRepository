package example.generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<T>(val waterSupply: T)

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    val tapWaterAquarium = Aquarium(TapWater())
    val stringAquarium = Aquarium("string")
    println(stringAquarium.javaClass)
    println(stringAquarium.waterSupply)
}