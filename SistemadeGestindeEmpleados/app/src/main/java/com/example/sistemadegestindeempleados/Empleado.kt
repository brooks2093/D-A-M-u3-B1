package com.example.sistemadegestindeempleados

interface Empleado {
    val nombre: String
    val id: String
    fun calcularSalario(): Double
}
