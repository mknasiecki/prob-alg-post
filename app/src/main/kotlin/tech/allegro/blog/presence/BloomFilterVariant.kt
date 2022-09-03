package tech.allegro.blog.presence

import com.google.common.hash.BloomFilter
import com.google.common.hash.Funnels
import kotlin.system.measureTimeMillis

class BloomFilterVariant {
    companion object {
        private const val n: Int = 10000000
        private const val f = 0.1

        @JvmStatic
        fun main(args: Array<String>) {
            val insertions = (n * f).toInt()
            val filter = BloomFilter.create(Funnels.integerFunnel(), insertions, 0.01)
            var falsePositives = 0

            //Pause the program to connect the process from jConsole
            println("Press enter to start")
            readln()

            val insertTime = measureTimeMillis {
                for (i in 0 until insertions) {
                    filter.put(i)
                }
            }

            val queryTime = measureTimeMillis {
                for (i in insertions until n) {
                    if (filter.mightContain(i)) {
                        falsePositives++;
                    }
                }
            }

            val fpRatio = falsePositives/n.toDouble()
            println("FP: $fpRatio")
            println("insert time: $insertTime ms")
            println("query time: $queryTime ms")
            readln()
        }
    }
}
