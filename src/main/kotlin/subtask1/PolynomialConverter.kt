package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var pow = numbers.size - 1
        if (pow<0)
            return null
        var polinom = ""
        while (pow >= 0) {
            val koeff = numbers[numbers.size - 1 - pow]
            if (koeff == 0)
            {
                pow -= 1
                continue
            }
            if (koeff == 1) {

            } else if (koeff == -1) {
                polinom += " - "
            } else if (koeff > 0) {
                polinom += " + " + koeff
            }
            else if (koeff < 0) {
                polinom += " - " + Math.abs(koeff)
            }

            if (pow == 1)
            {
                polinom += "x"
            }
            else if (pow == 0)
            {

            }
            else
            {
                polinom += "x^" + pow
            }
            pow -= 1
        }
        polinom = polinom.substring(3,polinom.length)
        return polinom
    }
}
