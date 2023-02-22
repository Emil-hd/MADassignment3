package dk.howards.assignments.dataclass

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class CarFactoryTest {
    @Test
    fun createCar() {
        // Arrange
        val make = Make.OPEL
        val model = "Corsa"
        val fabric = Fabric.LEATHER
        val engine = Engine.HP190
        val basePrice = 100000

        val prices2020 = EquipmentPrices(
            mapOf(Engine.HP210 to 400, Engine.HP190 to 300, Engine.HP120 to 100),
            mapOf(Fabric.COTTON to 2000, Fabric.PLASTIC to 1000, Fabric.LEATHER to 3000, Fabric.SILK to 30000)
        )

        // Act
        val res = Car.create(make, model, basePrice, fabric, engine, prices2020)

        // Assert
        Assertions.assertEquals(make, res.make)
        Assertions.assertEquals(model, res.model)
        Assertions.assertEquals(engine, res.engineType)
        Assertions.assertEquals(fabric, res.seatFabric)
        Assertions.assertEquals(basePrice, res.basePrice)
        Assertions.assertEquals(3300, res.equipmentPrice)
    }

    @Test
    fun enginePriceMissing() {
        //Arrange
        val enginePrices = mapOf(Engine.HP190 to 300, Engine.HP120 to 100)
        val fabricPrices =
            mapOf(Fabric.COTTON to 2000, Fabric.PLASTIC to 1000, Fabric.LEATHER to 3000, Fabric.SILK to 30000)
        // Act Assert
        assertFailsWith<Exception>(EquipmentPrices.ENGINE_PRICES_INCOMPLETE) {
            EquipmentPrices(enginePrices, fabricPrices)
        }

    }

    @Test
    fun fabricPriceMissing() {
        //Arrange
        val enginePrices = mapOf(Engine.HP210 to 400, Engine.HP190 to 300, Engine.HP120 to 100)
        val fabricPrices = mapOf(Fabric.PLASTIC to 1000, Fabric.LEATHER to 3000, Fabric.SILK to 30000)
        // Act Assert
        assertFailsWith<Exception>(EquipmentPrices.FABRIC_PRICES_INCOMPLETE) {
            EquipmentPrices(enginePrices, fabricPrices)
        }
    }
}