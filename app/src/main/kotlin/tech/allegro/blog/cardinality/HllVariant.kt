package tech.allegro.blog.cardinality

import org.apache.datasketches.hll.HllSketch
import org.apache.datasketches.hll.TgtHllType
import kotlin.system.measureTimeMillis

class HllVariant {
    companion object {

        private const val n: Long = 10000000
        private const val f = 0.75

        @JvmStatic
        fun main(args: Array<String>) {
            val sketch = HllSketch(12, TgtHllType.HLL_8)
            val mod = (n * f).toLong()
            var approxCardinality: Double

            //Pause the program to connect the process from jConsole
            println("Press enter to start")
            readln()

            val elapsed = measureTimeMillis {

                for (i in 1..n) {
                    sketch.update(i % mod)
                }

                approxCardinality = sketch.estimate
            }

            println("cardinality (approx): $approxCardinality")
            println("time: $elapsed ms")
            readln()
        }
    }
}
