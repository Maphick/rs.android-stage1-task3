package subtask4

class SquareDecomposer {
    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 5)
            return  null
        var squareSequence = mutableListOf<Int>()
        val newNumber = Math.pow(number.toDouble(), 2.0) - Math.pow((number-1).toDouble(), 2.0)
        val maxNumber = newNumber.toInt()
        for (i:Int in Math.sqrt(maxNumber.toDouble()).toInt()  downTo 0)
        {
            if ((i*i) == maxNumber) {
                squareSequence.addAll(listOf(i, number - 1))
                return squareSequence.toTypedArray()
            }
            for (j in i-1 downTo 0)
            {
                if ((i*i) + (j*j) == maxNumber) {
                    squareSequence.addAll(listOf(j, i, number - 1))
                    return squareSequence.toTypedArray()
                }
                for (k in j-1 downTo 0)
                {
                    if ((i*i) +(j*j) + (k*k) == maxNumber) {
                        squareSequence.addAll(listOf(k, j, i, number - 1))
                        return squareSequence.toTypedArray()
                    }
                    for (l in k-1 downTo 0)
                    {
                        if (((i*i)+(j*j)+(k*k)+(l*l)) == maxNumber)
                        {
                            squareSequence.addAll(listOf(l,k,j,i,number-1))
                            return squareSequence.toTypedArray()
                        }
                    }

                }
            }
        }
        return null
    }
}
