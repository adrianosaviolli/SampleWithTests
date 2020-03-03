package com.example.project.business

class ProjectBusiness {

    fun calculate(operation: String, number1: Double, number2: Double) : Double {
        when(operation) {
            SUM -> {
                return number1+number2
            }
            SUBTRACT -> {
                return number1-number2
            }
            MULT -> {
                return number1*number2
            }
            DIVIDE -> {
                return number1/number2
            }
        }
        return 0.0
    }

    fun isValidInfo(info: String?) : Boolean {
        return !info.isNullOrBlank()
    }

    companion object {
        const val SUM = "SUM"
        const val SUBTRACT = "SUBTRACT"
        const val MULT = "MULTIPLY"
        const val DIVIDE = "DIVIDE"
    }
}