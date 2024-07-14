import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // Reading the value of n
    val n = 8  // As per your requirement, we are fixing this to 10

    // Initialize the pair list
    val pairList = mutableListOf<Pair<Int, Int>>()

    // Reading the next n numbers and pairing them with sequence values
    for (i in 1..n) {
        val m = br.readLine().toInt()
        pairList.add(Pair(i, m))
    }
    // Sorting the pair list by the second element of the pairs in descending order
    pairList.sortByDescending { it.second }
    
    // Taking the top 5 pairs
    val top5Pairs = pairList.take(5)
    var answer = top5Pairs.sumOf { it.second }
    bw.write("${answer}\n")
    
    // Extracting the first elements of the top 5 pairs and sorting them
    val top5FirstElements = top5Pairs.map { it.first }.sorted()
    
    // Printing the sorted first elements
    bw.write(top5FirstElements.joinToString(" "))
    bw.flush()
    bw.close()
}
