package com.example.project.business

class ProjectBusiness {

    fun calculate(operation: String, number1: Double, number2: Double) : Double {
        when(operation) {
            SUM -> {
                return number1 + number2
            }
            SUB -> {
                return number1 - number2
            }
            MUL -> {
                return number1 * number2
            }
            DIV -> {
                return number1 / number2
            }
        }
        return 0.0
    }

    fun isValidInfo(info: Double?) : Boolean {
        return info != null
    }

    companion object {
        const val SUM = "SUM"
        const val SUB = "SUB"
        const val MUL = "MUL"
        const val DIV = "DIV"
    }
}