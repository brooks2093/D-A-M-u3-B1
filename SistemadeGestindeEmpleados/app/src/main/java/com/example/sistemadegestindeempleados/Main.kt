package com.example.sistemadegestindeempleados

fun main() {
    val gestionNomina = GestionNomina()

    println("Seleccione el tipo de empleado a ingresar:")
    println("1. Empleado Fijo")
    println("2. Empleado por Horas")
    println("3. Empleado por Comisión")

    val tipoEmpleado = readLine()!!.toInt()

    when (tipoEmpleado) {
        1 -> {
            // Datos para Empleado Fijo
            println("Ingrese el nombre del empleado fijo:")
            val nombreFijo = readLine()!!
            println("Ingrese el ID del empleado fijo:")
            val idFijo = readLine()!!
            println("Ingrese el salario mensual del empleado fijo:")
            val salarioFijo = readLine()!!.toDouble()

            val empleadoFijo = EmpleadoFijo(nombreFijo, idFijo, salarioFijo)
            gestionNomina.agregarEmpleado(empleadoFijo)
        }
        2 -> {
            // Datos para Empleado por Horas
            println("Ingrese el nombre del empleado por horas:")
            val nombreHoras = readLine()!!
            println("Ingrese el ID del empleado por horas:")
            val idHoras = readLine()!!
            println("Ingrese la tarifa por hora del empleado:")
            val tarifaPorHora = readLine()!!.toDouble()
            println("Ingrese las horas trabajadas del empleado:")
            val horasTrabajadas = readLine()!!.toInt()

            val empleadoPorHoras = EmpleadoPorHoras(nombreHoras, idHoras, tarifaPorHora, horasTrabajadas)
            gestionNomina.agregarEmpleado(empleadoPorHoras)
        }
        3 -> {
            // Datos para Empleado por Comisión
            println("Ingrese el nombre del empleado por comisión:")
            val nombreComision = readLine()!!
            println("Ingrese el ID del empleado por comisión:")
            val idComision = readLine()!!
            println("Ingrese el salario base del empleado por comisión:")
            val salarioBaseComision = readLine()!!.toDouble()
            println("Ingrese el porcentaje de comisión (ej. 0.1 para 10%):")
            val porcentajeComision = readLine()!!.toDouble()
            println("Ingrese las ventas generadas por el empleado:")
            val ventasGeneradas = readLine()!!.toDouble()

            val empleadoPorComision = EmpleadoPorComision(nombreComision, idComision, salarioBaseComision, porcentajeComision, ventasGeneradas)
            gestionNomina.agregarEmpleado(empleadoPorComision)
        }
        else -> {
            println("Tipo de empleado inválido. Por favor, seleccione una opción válida.")
            return
        }
    }

    // Mostrar empleados y calcular nómina total
    gestionNomina.mostrarEmpleados()
    val nominaTotal = gestionNomina.calcularNominaTotal()
    println("Nómina total: %.2f".format(nominaTotal))
}
