package tech.allegro.blog.cardinality

import kotlin.system.measureTimeMillis

class DistinctVariant {
    companion object {

        private const val n: Long = 10000000
        private const val f = 0.75

        @JvmStatic
        fun main(args: Array<String>) {
            val list = ArrayList<Long>()
            val mod = (n * f).toLong()
            var cardinality: Int

            //Pause the program to connect the process from jConsole
            println("Press enter to start")
            readln()

            val elapsed = measureTimeMillis {

                for (i in 0 until n) {
                    list.add(i % mod)
                }

                cardinality = list.distinct().count()
            }

            println("cardinality: $cardinality")
            println("time: $elapsed ms")
            readln()
        }
    }
}
