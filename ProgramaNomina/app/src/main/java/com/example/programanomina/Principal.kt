package com.example.programanomina

fun main() {
    // Solicitar datos del trabajador
    println("Ingrese el nombre del trabajador:")
    val nombre = readLine() ?: ""

    println("Ingrese la categoría del trabajador (1, 2 o 3):")
    val categoria = readLine()?.toIntOrNull() ?: 3

    println("Ingrese las horas trabajadas en la semana:")
    val horasTrabajo = readLine()?.toDoubleOrNull() ?: 0.0

   // println("Ingrese las horas extras trabajadas en la semana:")
    //val horasExtra = readLine()?.toDoubleOrNull() ?: 0.0

    // Crear objeto Trabajador
    val trabajador = Trabajador(nombre, categoria, horasTrabajo )

    // Crear objeto Calcular
    val calculadora = Calcular()

    // Calcular el sueldo semanal
    val sueldoSemanal = calculadora.calcularSueldoSemanal(trabajador)
    println("El sueldo semanal de $nombre es: $sueldoSemanal")
}
