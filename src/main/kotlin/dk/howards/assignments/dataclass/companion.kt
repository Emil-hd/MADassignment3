package dk.howards.assignments.dataclass

fun main() {

}

enum class Fabric {
    LEATHER, COTTON, PLASTIC, SILK
}

enum class Engine {
    HP120, HP190, HP210
}

enum class Make() {
    OPEL, AUDI, KIA
}

class Car private constructor(
    val make: Make,
    val model: String,
    val seatFabric: Fabric,
    val engineType: Engine,
    val basePrice: Int,
    val equipmentPrice: Int
) {
    companion object Factory : CarFactory() {
        override fun create(
            make: Make,
            model: String,
            basePrice: Int,
            fabric: Fabric,
            engineType: Engine,
            equipmentPrices: EquipmentPrices
        ): Car {
            // implement the current implementation is just for compiling
            return Car(
                Make.AUDI, "model", Fabric.COTTON, Engine.HP210, 0, 0
            )
        }
    }

    override fun toString(): String {
        return "Make:${make.name} Model:$model Fabric:${seatFabric.name} Engine:${engineType.name} BasePrice: $basePrice EquipmentPrice: $equipmentPrice"
    }
}

data class EquipmentPrices(val enginePrices: Map<Engine, Int>, val fabricPrices: Map<Fabric, Int>) {

    companion object {
        const val ENGINE_PRICES_INCOMPLETE = "Engine Prices are incomplete"
        const val FABRIC_PRICES_INCOMPLETE = "Fabric Prices are incomplete"
    }
}

abstract class CarFactory {

    protected fun additionalPrice(engineType: Engine, fabric: Fabric, equipmentPrices: EquipmentPrices): Int {
        return 0;
    }

    abstract fun create(
        make: Make, model: String, basePrice: Int, fabric: Fabric, engineType: Engine, equipmentPrices: EquipmentPrices
    ): Car
}