package tech.allegro.blog.cardinality

import kotlin.system.measureTimeMillis

class HashSetVariant {
    companion object {

        private const val n: Long = 10000000
        private const val f = 0.25

        @JvmStatic
        fun main(args: Array<String>) {
            val mod = (n * f).toLong()
            val set = HashSet<Long>(mod.toInt())
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
            println("cardinality2: $mod")
            println("time: $elapsed ms")
            readln()
        }
    }
}
