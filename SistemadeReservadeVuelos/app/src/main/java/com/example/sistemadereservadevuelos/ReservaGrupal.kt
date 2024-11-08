package com.example.sistemadereservadevuelos

class ReservaGrupal(private val descuento: Double) : Reserva {
    private val reservas = mutableListOf<Reserva>()

    fun agregarReserva(reserva: Reserva) {
        reservas.add(reserva)
    }

    override fun calcularCosto(): Double {
        val costoTotal = reservas.sumOf { it.calcularCosto() }
        return costoTotal * (1 - descuento)
    }

    override fun toString(): String {
        return "Reserva Grupal - Descuento: %.2f%%, Costo Total: %.2f".format(descuento * 100, calcularCosto())
    }
}

