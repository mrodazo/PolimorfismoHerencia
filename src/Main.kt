import kotlin.random.Random

open class Padre {
    val numAleatorio: Int = Random.nextInt(100, 1000)

    open fun dameNumero(): Int {
        return numAleatorio
    }

    fun dameTamanio(texto: String): Int {
        return texto.length
    }
}

class Hija(var descripcion: String = "Clase Derivada") : Padre() {
    var contador: Int = 0

    override fun dameNumero(): Int {
        contador++
        println("Mostramos descripcion desde la función dameNumero() -> $descripcion")
        return contador
    }

    fun muestraDescripcion() {
        println(descripcion)
    }
}

fun main() {
    val padre1 = Padre()
    println("Info de padre1:")
    println("--------------")
    println("dameNumero() en padre: ${padre1.dameNumero()}")
    println("numAleatorio = ${padre1.numAleatorio}")//Da siempre el mismo num, porque es val en la clase
    println("numAleatorio = ${padre1.numAleatorio}")//Da siempre el mismo num, porque es val en la clase
    println("numAleatorio = ${padre1.numAleatorio}")//Da siempre el mismo num, porque es val en la clase
    println("dameTamanio('padre1 como Padre') = ${padre1.dameTamanio("padre1 como Padre")}")

    println()

    val padre2 : Padre = Hija()
    println("Info de padre2:")
    println("--------------")
    println("dameNumero() en padre2: ${padre2.dameNumero()}")
    println("numAleatorio = ${padre2.numAleatorio}")
    println("dameNumero() en padre2: ${padre2.dameNumero()}")
    println("dameNumero() en padre2: ${padre2.dameNumero()}")
    println("dameNumero() en padre2: ${padre2.dameNumero()}")
    println("numAleatorio = ${padre2.numAleatorio}")
    println("dameTamanio('padre2 como Padre instanciado con Hija()') = ${padre2.dameTamanio("padre2 como Padre instanciado con Hija()")}")

    // El objeto padre2 es de tipo Padre y no puede llamar a muestraDescripcion(),
    // que es un método propio de la clase Hija
    // padre2.muestraDescripcion()
    // Tampoco puede acceder directamente a contador, ya que es una propiedad
    // de la clase Hija.
    //println("contador = ${padre2.contador}")

    // Casting de padre2 a Hija en línea para llamar a
    // contador y muestraDescripcion() directamente.
    val padre2ComoHija = (padre2 as Hija)
    println("Info de padre2ComoHija:")
    println("--------------")
    println("dameNumero() en padre2ComoHija: ${padre2ComoHija.dameNumero()}")
    println("dameNumero() en padre2ComoHija: ${padre2ComoHija.dameNumero()}")
    println("dameNumero() en padre2ComoHija: ${padre2ComoHija.dameNumero()}")
    padre2ComoHija.muestraDescripcion()
    println("contador = ${padre2ComoHija.contador}")
    println("numAleatorio = ${padre2ComoHija.numAleatorio}")
    println("numAleatorio = ${padre2ComoHija.numAleatorio}")
    println("dameTamanio('padre2 con Casting a Hija') = ${padre2ComoHija.dameTamanio("padre2 con Casting a Hija")}")
}