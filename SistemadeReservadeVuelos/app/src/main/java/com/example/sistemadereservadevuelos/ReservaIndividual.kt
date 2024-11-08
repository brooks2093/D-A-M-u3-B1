package com.example.sistemadereservadevuelos

class ReservaIndividual(
    private val nombrePasajero: String,
    private val tarifa: String, // "economica" o "ejecutiva"
    private val precioBase: Double
) : Reserva {

    override fun calcularCosto(): Double {
        return when (tarifa.lowercase()) {
            "economica" -> precioBase
            "ejecutiva" -> precioBase * 1.5
            else -> throw IllegalArgumentException("Tipo de tarifa inválido. Solo se permiten las tarifas: economica o ejecutiva.")
        }
    }

    override fun toString(): String {
        return "$nombrePasajero - Tarifa: $tarifa, Costo: %.2f".format(calcularCosto())
    }
}
