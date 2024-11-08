package com.example.programanomina

class Calcular {
    val PrecioHoraBase = 90.0
    val horasExtra= 0.0

    fun calcularSueldoSemanal(trabajador: Trabajador): Double {
        val precioHora = calcularPrecioHora(trabajador.categoria)
        val precioHoraExtra = calcularPrecioHoraExtra(precioHora)

        return trabajador.horasTrabajo * precioHora + horasExtra * precioHoraExtra
    }

    private fun calcularPrecioHora(categoria: Int): Double {
        return when (categoria) {
            1 -> PrecioHoraBase * 1.45
            2 -> PrecioHoraBase * 1.25
            else -> PrecioHoraBase
        }
    }

    private fun calcularPrecioHoraExtra( precioHora: Double): Double {
        return when {

            horasExtra < 10 -> precioHora * 1.5
            horasExtra in 10.0..20.0 -> precioHora * 1.4
            else -> precioHora * 1.2
        }
    }
}