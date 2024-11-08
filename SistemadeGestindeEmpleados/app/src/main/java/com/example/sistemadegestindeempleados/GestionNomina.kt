package com.example.sistemadegestindeempleados

class GestionNomina {
    private val empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun calcularNominaTotal(): Double {
        return empleados.sumOf { it.calcularSalario() }
    }

    fun mostrarEmpleados() {
        empleados.forEach { println(it) }
    }
}
