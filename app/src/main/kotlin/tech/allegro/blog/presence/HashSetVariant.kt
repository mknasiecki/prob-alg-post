package tech.allegro.blog.presence

import kotlin.system.measureTimeMillis

class HashSetVariant {
    companion object {
        private const val n: Int = 10000000
        private const val f = 0.1

        @JvmStatic
        fun main(args: Array<String>) {
            val insertions = (n * f).toInt()
            val set = HashSet<Int>(insertions)

            //Pause the program to connect the process from jConsole
            println("Press enter to start")
            readln()

            val insertTime = measureTimeMillis {
                for (i in 0 until insertions) {
                    set.add(i)
                }
            }

            val queryTime = measureTimeMillis {
                for (i in insertions until n) {
                    set.contains(i)
                }
            }

            println("insert time: $insertTime ms")
            println("test time: $queryTime ms")
            readln()
        }
    }
}
