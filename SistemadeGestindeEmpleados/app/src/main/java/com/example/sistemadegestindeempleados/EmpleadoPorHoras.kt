package com.example.sistemadegestindeempleados

class EmpleadoPorHoras(
    override val nombre: String,
    override val id: String,
    private val tarifaPorHora: Double,
    private val horasTrabajadas: Int
) : Empleado {

    override fun calcularSalario(): Double {
        val horasExtras = if (horasTrabajadas > 40) horasTrabajadas - 40 else 0
        val salarioHorasNormales = tarifaPorHora * (horasTrabajadas - horasExtras)
        val salarioHorasExtras = horasExtras * tarifaPorHora * 1.5
        return salarioHorasNormales + salarioHorasExtras
    }

    override fun toString(): String {
        return "Empleado por Horas - Nombre: $nombre, ID: $id, Salario: %.2f".format(calcularSalario())
    }
}
