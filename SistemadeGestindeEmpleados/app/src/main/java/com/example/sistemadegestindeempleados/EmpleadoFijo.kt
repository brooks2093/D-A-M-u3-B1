package com.example.sistemadegestindeempleados

class EmpleadoFijo(
    override val nombre: String,
    override val id: String,
    private val salarioMensual: Double
) : Empleado {
    override fun calcularSalario(): Double {
        return salarioMensual
    }

    override fun toString(): String {
        return "Empleado Fijo - Nombre: $nombre, ID: $id, Salario: %.2f".format(calcularSalario())
    }
}
