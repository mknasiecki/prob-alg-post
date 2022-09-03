package tech.allegro.blog.cardinality

import kotlin.system.measureTimeMillis

class HashSetVariant {
    companion object {

        private const val n: Long = 10000000
        private const val f = 0.75

        @JvmStatic
        fun main(args: Array<String>) {
            val set = HashSet<Long>()
            val mod = (n * f).toLong()
            var cardinality: Int

            //Pause the program to connect the process from jConsole
            println("Press enter to start")
            readln()

            val elapsed = measureTimeMillis {
                for (i in 0 until n) {
                    set.add(i % mod)
                }

                cardinality = set.size
            }

            println("cardinality: $cardinality")
            println("time: $elapsed ms")
            readln()
        }
    }
}
