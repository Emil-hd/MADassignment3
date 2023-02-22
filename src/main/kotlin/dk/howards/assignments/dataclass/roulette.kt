package dk.howards.assignments.dataclass

import java.util.Date
import kotlin.random.Random

fun main() {
    val n = getSpinner(System.currentTimeMillis())
    var m = n()

    println(m)
    var WinningBetTypes =  showSpinResult(m)
    for (types in WinningBetTypes) {
        println(types)
    }

    m = n()
    println(m)
    WinningBetTypes =  showSpinResult(m)
    for (types in WinningBetTypes) {
        println(types)
    }

    m = n()
    println(m)
    WinningBetTypes =  showSpinResult(m)
    for (types in WinningBetTypes) {
        println(types)
    }


}



// Use the kotlin.random.Random method nextInt(bound)
fun getSpinner(seed: Long): () -> Int {

//System.currentTimeMillis()
    var random =     Random(seed)
    return { random.nextInt(1,36) }
}

fun showSpinResult(number: Int): List<String> {
    val WinningBetTypes = mutableListOf<String>()

    WinningBetTypes.add("NUMBER_$number")

    if (BetType.BLACK.numbers.contains(number))
    {
        WinningBetTypes.add("Red")
    }
    if (BetType.RED.numbers.contains(number))
    {
        WinningBetTypes.add("Red")
    }
    if (BetType.ODD.numbers.contains(number))
    {
        WinningBetTypes.add("Odd")
    }
    if (BetType.EVEN.numbers.contains(number))
    {
        WinningBetTypes.add("Even")
    }
    return WinningBetTypes;
}

fun calculateWin(number: Int, bet: RouletteBet): Int {// implement  as specified
    return 0
}

fun calculateWin(number: Int, bet: RouletteBets): Int {//implement  as specified
    return 0
}

data class RouletteBet(val something:Int)// implement as specified

data class RouletteBets(val something:Int)// implement  as specified

public enum class BetType(val numbers: Array<Int>, val odds: Int) {
    EVEN((2..36 step 2).toList().toTypedArray(), 2),
    ODD((1..35 step 2).toList().toTypedArray(), 2),
    RED(arrayOf(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35), 2),
    BLACK(arrayOf(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36), 2),
    NUMBER_0(arrayOf(0), 36),
    NUMBER_1(arrayOf(1), 36),
    NUMBER_2(arrayOf(2), 36),
    NUMBER_3(arrayOf(3), 36),
    NUMBER_4(arrayOf(4), 36),
    NUMBER_5(arrayOf(5), 36),
    NUMBER_6(arrayOf(6), 36),
    NUMBER_7(arrayOf(7), 36),
    NUMBER_8(arrayOf(8), 36),
    NUMBER_9(arrayOf(9), 36),
    NUMBER_10(arrayOf(10), 36),
    NUMBER_11(arrayOf(11), 36),
    NUMBER_12(arrayOf(12), 36),
    NUMBER_13(arrayOf(13), 36),
    NUMBER_14(arrayOf(14), 36),
    NUMBER_15(arrayOf(15), 36),
    NUMBER_16(arrayOf(16), 36),
    NUMBER_17(arrayOf(17), 36),
    NUMBER_18(arrayOf(18), 36),
    NUMBER_19(arrayOf(19), 36),
    NUMBER_20(arrayOf(20), 36),
    NUMBER_21(arrayOf(21), 36),
    NUMBER_22(arrayOf(22), 36),
    NUMBER_23(arrayOf(23), 36),
    NUMBER_24(arrayOf(24), 36),
    NUMBER_25(arrayOf(25), 36),
    NUMBER_26(arrayOf(26), 36),
    NUMBER_27(arrayOf(27), 36),
    NUMBER_28(arrayOf(28), 36),
    NUMBER_29(arrayOf(29), 36),
    NUMBER_30(arrayOf(30), 36),
    NUMBER_31(arrayOf(31), 36),
    NUMBER_32(arrayOf(32), 36),
    NUMBER_33(arrayOf(33), 36),
    NUMBER_34(arrayOf(34), 36),
    NUMBER_35(arrayOf(35), 36),
    NUMBER_36(arrayOf(36), 36)
}