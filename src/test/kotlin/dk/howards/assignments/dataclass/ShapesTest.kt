package dk.howards.assignments.dataclass

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ShapesTest {

    @Test
    fun testCircle() {
        // Arrange
        val radius = 2.0
        val circle = Circle(radius)

        // Act
        val res = circle.calculateArea()

        // Assert
        Assertions.assertEquals(4 * Math.PI, res, 0.01)
    }

    @Test
    fun testRectAngle() {
        // Arrange
        val height = 2.0
        val width = 3.0
        val rectAngle = RectAngle(height, width)

        // Act
        val res = rectAngle.calculateArea()

        // Assert
        Assertions.assertEquals(6.0, res, 0.01)
    }

    @Test
    fun testComposition() {
        // Arrange

        val rectAngle1 = RectAngle(1.0, 2.0)
        val rectAngle2 = RectAngle(3.0, 2.0)
        val rectAngle3 = RectAngle(4.0, 2.0)
        val comp1 = Composition(rectAngle1, rectAngle2)
        val comp2 = Composition(rectAngle3, comp1)

        // Act
        val res = comp2.calculateArea()

        // Assert
        Assertions.assertEquals(2 + 6 + 8.0, res, 0.01)
    }
}