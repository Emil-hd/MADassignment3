package dk.howards.assignments.dataclass

fun main() {

}

abstract class Shape {
    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea(): Double {
        return 0.0
    }
}

class RectAngle(private val height: Double, private val width: Double) : Shape() {
    override fun calculateArea(): Double {
        return 0.0;
    }
}

class Composition(vararg shapes: Shape) : Shape() {
    private val list = shapes.toList()
    override fun calculateArea(): Double {
        return 0.0
    }
}

