/* -----PROGRAM  FOR HOME ACCOMODATION-------

 * My first ever self-written Kotlin code, with 
 * complete understanding of each line of code
 * written; why it was used and what it does.
 
 * This program is created as part of my ongoing
 * Kotlin learning journey, via Google's codelab
 * on this topic. Link to the codelab can be found
 * in the README section of the repository. 

 * To try out this code, please run it on
 * Kotlin Playground, for quick testing without any 
 * installations needed. Link: https://play.kotlinlang.org/

 * EMJOY!

 */

import kotlin.math.PI

/* Abstract base class from which all the 
 * individual house types would inherit 
 * their property from. 
*/

abstract class Dwelling(var residents: Int) {
    abstract val buildMaterial: String               // Some of the values are declared abstract so that they could be defined later in subclasses.
    abstract val capacity: Int
    abstract val length: Double
    abstract fun floorArea(): Double
    
    fun hasRoom(): String {                          // This function would return the status of room availability. 
        val bool: Boolean
        bool = residents < capacity
        if(bool == true) {
            var message = "Congrats! You got a Room."
            return message
        } else {
            var message = "Sorry :( Try again later.."
            return message
        }
    }
}

/* Square-Cabin class definition */

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildMaterial = "Wood"              // 'override' statement helps to redefine a value or a method belonging to the original class.
    override val capacity = 6
    override val length = 10.2
    override fun floorArea(): Double {               // Method to calculate the floor area of the house. This function definition depends--
        return length*length                         // --on the room type
    }
}

/* Round-Hut class definition */

open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildMaterial = "Straw"
    override val capacity = 7
    override val length = 11.3
    override fun floorArea(): Double {
        return PI*length*length
    }
}

/* Round-Tower class definition */

class RoundTower(residents: Int) : RoundHut(residents) {  // Since this house-type is primarily round, it hence inherits its definition--
    val floors: Int = 4                                   // --from the class RoundHut
    
    override val buildMaterial = "Stone"
    override val capacity = 3*floors
    override val length = 10.0
    
    override fun floorArea(): Double {
        return PI*length*length*floors
    }
}


/* Kotlin driver program. (Also called as entry-point of the application) */

fun main() {
    val squareCabin = SquareCabin(4)                      // Class constructors are called for object instantiation. 
    val roundHut = RoundHut(8)
    val roundTower = RoundTower(10)
    
    with(squareCabin){                                    // with() executes a series of statements for the object that is passed to it.
        println("\nSquare Cabin for ${residents} people\n==========================")
        println("Material: ${buildMaterial}")
        println("Room Capacity: ${capacity}")
        println("Room Status: "+ hasRoom())
        println("Floor area: %.2f".format(floorArea()))
    }
    
    with(roundHut){
        println("\nRound Hut for ${residents} people\n==========================")
        println("Material: ${buildMaterial}")
        println("Room Capacity: ${capacity}")
        println("Room Status: "+ hasRoom())
        println("Floor area: %.2f".format(floorArea()))
    }
    
    with(roundTower){
        println("\n${floors}-storeyed Round Tower for ${residents} people\n=======================================")
        println("Material: ${buildMaterial}")
        println("Room Capacity: ${capacity}")
        println("Room Status: "+ hasRoom())
        println("Floor area: %.2f".format(floorArea()))
    }
}