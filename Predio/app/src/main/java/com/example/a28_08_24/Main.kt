package com.example.a28_08_24

// Main.kt
fun main() {


    val zonas = listOf(
        Zona("MAR", "Marginado", 2.00),
        Zona("RUR", "Rural", 8.00),
        Zona("URB", "Urbana", 10.00),
        Zona("RES", "Residencial", 25.00)
    )

    // Solicitar datos de la persona
    print("Ingrese el nombre de la persona: ")
    val nombre = readLine()!!

    print("Ingrese la edad de la persona: ")
    val edad = readLine()!!.toInt()

    print("¿Es madre soltera? (sí/no): ")
    val esMadreSoltera = readLine()!!.trim().equals("sí", ignoreCase = true)

    val persona = Persona(nombre, edad, esMadreSoltera)

    // Solicitar predios
    val predios = mutableListOf<Predio>()
    while (true) {
        println("Ingrese los datos del predio:")
        println("Seleccione la zona (MAR, RUR, URB, RES):")
        val claveZona = readLine()!!.trim()
        val zona = zonas.find { it.clave == claveZona }

        if (zona == null) {
            println("Zona no válida. Intente nuevamente.")
            continue
        }

        print("Ingrese los metros cuadrados del predio: ")
        val metrosCuadrados = readLine()!!.toDouble()

        predios.add(Predio(zona, metrosCuadrados))

        print("¿Desea agregar otro predio? (sí/no): ")
        val respuesta = readLine()!!.trim().equals("sí", ignoreCase = true)
        if (!respuesta) break
    }

    // Solicitar mes de pago
    print("Ingrese el mes de pago (1 para enero, 2 para febrero, etc.): ")
    val mes = readLine()!!.toInt()

    // Calcular el impuesto
    val impuestoPredial = ImpuestoPredial()
    val total = impuestoPredial.calcularImpuestoTotal(predios, persona, mes)
    println("El total del impuesto predial a pagar es: \$${"%.2f".format(total)}")
}

