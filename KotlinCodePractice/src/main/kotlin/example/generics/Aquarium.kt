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

class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) {
            "water supply needs processing first"
        }
        println("adding water from $waterSupply")
    }
}

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    try {aquarium.addWater()}
    catch (e: Exception){
        println(e.localizedMessage)
    }

    val lakeWaterAquarium = Aquarium(LakeWater())
    try {
        lakeWaterAquarium.addWater()
    } catch (e: Exception) {
        println(e.stackTrace.toString())
    }
    lakeWaterAquarium.waterSupply.filter()
    lakeWaterAquarium.addWater()

    val tapWaterAquariumOut = AquariumOut(TapWater())
    addItemTo(tapWaterAquariumOut)

    val tapWaterCleaner = TapWaterCleaner()
    val aquariumOut = AquariumOut(TapWater())
    aquariumOut.addWater(tapWaterCleaner)
}

class AquariumOut<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}

fun addItemTo(aquariumOut: AquariumOut<WaterSupply>) = println("item added")

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}
