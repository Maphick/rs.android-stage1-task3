package subtask2

class Combinator {

    fun Fact(n:Int):Long {
        if (n<=1)
            return 1
        else
            return n*Fact(n-1)
    }

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        if (array.size < 2)
            return null
        var m = array[0]
        var n:Int = array[1]
        var number = Fact(n)/m
        for (x in 1..n-1)
        {
            if (Fact(x)*Fact(n-x) == number)
                return x
        }
        return null
    }
}
