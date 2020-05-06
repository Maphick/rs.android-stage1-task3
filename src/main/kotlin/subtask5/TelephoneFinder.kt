package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    val neigborsOfDigit = mutableMapOf(
        '0' to listOf<Char>('8'),
        '1' to listOf<Char>('2','4'),
        '2' to listOf<Char>('1','3','5'),
        '3' to listOf<Char>('2', '6'),
        '4' to listOf<Char>('1','5','7'),
        '5' to listOf<Char>('2','4','6','8'),
        '6' to listOf<Char>('3','5','9'),
        '7' to listOf<Char>('4','8'),
        '8' to listOf<Char>('0','5','7','9'),
        '9' to listOf<Char>('6','8')
    )

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var allNeighbors = mutableListOf<String>()
        val numberSize = number.length
        for (i:Int in 0..numberSize-1)
        //digit in number)
        {
            if (!number[i].isDigit())
                return null
            val neighbors = neigborsOfDigit[number[i]]
            if (neighbors != null) {
                for (neighborDigit in neighbors) {
                    val beforeDigit = if (i!=0) {number.substring(0,i)} else {""}
                    val afterDigit = if (i!=numberSize) {number.substring(i+1,numberSize)} else {""}
                    val neighborNumber = beforeDigit + neighborDigit + afterDigit
                    allNeighbors.add(neighborNumber)
                }
            }

        }
        return allNeighbors.toTypedArray();
    }
}
