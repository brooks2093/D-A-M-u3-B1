package com.example.sistemadereservadevuelos

fun main() {
    val reservas = mutableListOf<Reserva>()
    var continuar = true

    while (continuar) {
        println("Seleccione el tipo de reserva: 1. Individual 2. Grupal")
        val tipoReserva = readLine()?.toIntOrNull()

        when (tipoReserva) {
            1 -> {
                // Solicitar datos para una reserva individual
                print("Ingrese el nombre del pasajero: ")
                val nombre = readLine() ?: ""

                var tarifa: String
                var tarifaValida = false
                do {
                    print("Ingrese el tipo de tarifa (economica/ejecutiva): ")
                    tarifa = readLine() ?: ""
                    if (tarifa.lowercase() == "economica" || tarifa.lowercase() == "ejecutiva") {
                        tarifaValida = true
                    } else {
                        println("Tipo de tarifa inválido. Solo se permiten las tarifas: economica o ejecutiva.")
                    }
                } while (!tarifaValida)

                print("Ingrese el precio base de la tarifa: ")
                val precioBase = readLine()?.toDoubleOrNull() ?: 0.0

                // Crear una reserva individual solo si la tarifa es válida
                val reservaIndividual = ReservaIndividual(nombre, tarifa, precioBase)
                reservas.add(reservaIndividual)

                println("Reserva individual creada: $reservaIndividual")
            }

            2 -> {
                // Crear una reserva grupal
                print("Ingrese el descuento para la reserva grupal (por ejemplo, 0.1 para 10%): ")
                val descuento = readLine()?.toDoubleOrNull() ?: 0.0

                val reservaGrupal = ReservaGrupal(descuento)

                // Agregar reservas individuales a la grupal
                var agregarMas = true
                while (agregarMas) {
                    println("¿Desea agregar una reserva individual a la reserva grupal? (s/n)")
                    val respuesta = readLine()
                    if (respuesta.equals("s", ignoreCase = true)) {
                        print("Ingrese el nombre del pasajero: ")
                        val nombre = readLine() ?: ""

                        var tarifa: String
                        var tarifaValida = false
                        do {
                            print("Ingrese el tipo de tarifa (economica/ejecutiva): ")
                            tarifa = readLine() ?: ""
                            if (tarifa.lowercase() == "economica" || tarifa.lowercase() == "ejecutiva") {
                                tarifaValida = true
                            } else {
                                println("Tipo de tarifa inválido. Solo se permiten las tarifas: economica o ejecutiva.")
                            }
                        } while (!tarifaValida)

                        print("Ingrese el precio base de la tarifa: ")
                        val precioBase = readLine()?.toDoubleOrNull() ?: 0.0

                        val reservaIndividual = ReservaIndividual(nombre, tarifa, precioBase)
                        reservaGrupal.agregarReserva(reservaIndividual)
                        println("Reserva individual añadida a la reserva grupal: $reservaIndividual")
                    } else {
                        agregarMas = false
                    }
                }
                reservas.add(reservaGrupal)
                println("Reserva grupal creada: $reservaGrupal")
            }

            else -> println("Opción no válida, intente nuevamente.")
        }

        // Preguntar si desea agregar más reservas
        println("¿Desea agregar otra reserva? (s/n)")
        val respuestaContinuar = readLine()
        if (respuestaContinuar.equals("n", ignoreCase = true)) {
            continuar = false
        }
    }

    // Mostrar todas las reservas creadas
    println("\nResumen de Reservas:")
    reservas.forEach { println(it) }

    // Calcular y mostrar el costo total de todas las reservas
    val costoTotal = reservas.sumOf { it.calcularCosto() }
    println("Costo total de todas las reservas: %.2f".format(costoTotal))
}
