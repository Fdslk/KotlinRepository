package example.myapp

class Aquarium(width: Int = 20, height: Int = 40, length: Int = 100) {
    var width: Int = width
    var height: Int = height
    var length: Int = length
    var volume: Int
        get() =  width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume l")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        println("using numberOfFish internal constructor for Aquarium")
        height =  (tank / (length * width)).toInt()
    }
}

class AquariumVolume (length: Int = 100, width: Int = 20, height: Int = 40) {
    var length: Int = length
    var width: Int = width
    var height: Int = height
    init {
        println("aquarium initializing")
        println("unit converting")
        this.length *= 10
        this.width *= 10
        this.height *= 10
    }
    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${this.width * this.length * this.height / 1000} l")
    }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
}

fun buildAquarium() {
    val aquarium = Aquarium()
    aquarium.printSize()
    val aquarium1 = Aquarium(1, 2, 3)
    aquarium1.printSize()
    val aquariumVolume = AquariumVolume()
    aquariumVolume.printSize()
    val aquarium2 = Aquarium(numberOfFish = 29)
    aquarium2.printSize()
}
