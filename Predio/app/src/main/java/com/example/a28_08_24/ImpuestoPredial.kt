package com.example.a28_08_24



    /*
    private val zonas = listOf(
        Zona("MAR", "Marginado", 2.00),
        Zona("RUR", "Rural", 8.00),
        Zona("URB", "Urbana", 10.00),
        Zona("RES", "Residencial", 25.00)
    )

     */

// ImpuestoPredial.kt
    class ImpuestoPredial {
    // Método para calcular el impuesto total
    fun calcularImpuestoTotal(predios: List<Predio>, persona: Persona, mes: Int): Double {
        val total = predios.sumOf { predio ->
            val costoBase = predio.zona.costoPorMetro * predio.metrosCuadrados
            val descuento = calcularDescuento(persona, mes)
            costoBase * (1 - descuento)
        }
        return total
    }

    // Método para determinar el descuento aplicable
    private fun calcularDescuento(persona: Persona, mes: Int): Double {
        val esTemporada = mes == 1 || mes == 2
        val descuentoBase = when {
            persona.edad >= 70 || persona.esMadreSoltera -> if (esTemporada) 0.70 else 0.50
            else -> if (esTemporada) 0.40 else 0.0
        }
        return descuentoBase
    }
}
