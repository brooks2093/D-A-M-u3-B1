package com.example.sistemadegestindeempleados

class EmpleadoPorComision(
    override val nombre: String,
    override val id: String,
    private val salarioBase: Double,
    private val porcentajeComision: Double,
    private val ventasGeneradas: Double
) : Empleado {

    override fun calcularSalario(): Double {
        return salarioBase + (porcentajeComision * ventasGeneradas)
    }

    override fun toString(): String {
        return "Empleado por Comisión - Nombre: $nombre, ID: $id, Salario: %.2f".format(calcularSalario())
    }
}
