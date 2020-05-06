package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        val itemsArray:List<Int> = itemsFromArray.filter { it is Int } as List<Int>
        val itemsArrayInt: Array<Int> = itemsArray.toTypedArray()

        itemsArrayInt.sortWith(Comparator { c1: Int, c2: Int -> Math.abs(c1) - Math.abs(c2) })
        if (itemsArrayInt.count() == 0)
            return 0
        var product = 1
        var nFactors = mutableListOf<Int>()
        var firstNegative = 0
        var firstPositive = 0
        var secondNegative = 0
        var secondPositive = 0
        if (itemsArrayInt.size < numberOfItems)
        {
            for (i in 0..itemsArrayInt.size-1) {
                var factor = itemsArrayInt[itemsArrayInt.size - 1 - i]
                product *= factor
            }
            return product
        }
        for (i in 0..numberOfItems-1) {
            var factor = itemsArrayInt[itemsArrayInt.size - 1 - i]
            product *= factor
            nFactors.add(factor)
            // минимальное из выбранных отрицательных чисел
            if (factor < 0)
                firstNegative = factor
            if (factor > 0)
                firstPositive = factor
        }
        if (product > 0)
            return product
        // массив без первых n максималльных значений
        val restArray:List<Int> = itemsArrayInt.dropLast(numberOfItems) as List<Int>
        val restArrayInt: Array<Int> = restArray.toTypedArray()


        for (i in restArrayInt.size-1 downTo 0)
        {
            if ((secondNegative!=0) && (secondPositive!=0))
            {
                break
            }
            if ((restArrayInt[i] < 0) && (restArrayInt[i] < secondNegative)) {
                secondNegative = restArrayInt[i]
            }
            if ((restArrayInt[i] > 0) && (restArrayInt[i] > secondPositive )) {
                secondPositive = restArrayInt[i]
            }
        }

        if ((firstPositive * secondPositive) > (firstNegative * secondNegative))
        {
         product = (product/firstNegative) * secondPositive
        }
        else
        {
            product = (product/firstPositive) * secondNegative
        }

        return product
    }
}
