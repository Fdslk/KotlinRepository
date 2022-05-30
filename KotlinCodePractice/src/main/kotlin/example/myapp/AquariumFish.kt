package example.myapp

class Plecostomus(fishColor: FishColor = GolderColor ) : FishAction, FishColor by fishColor{
    override fun eat() {
        println("eat algae")
    }
}

class Shark: FishAction, FishColor {
    override fun eat() {
        println("hunt and eat fish")
    }

    override val color: String
        get() = "gray"

}

object GolderColor: FishColor {
    override val color: String
        get() = "gold"

}

object BlackColor: FishColor {
    override val color: String
        get() = "black"

}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

