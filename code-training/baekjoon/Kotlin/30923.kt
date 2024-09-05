import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()
  val h = br.readLine().split(' ').map { it.toInt() } //
  var result = 0L
  result += h.sumOf { it } * 2L
  result += n*2L
  result += h[0]
  result += if (n>1 && h[0]>=h[1]) h[0]-h[1] else 0
  result += h[n-1]
  result += if (n>1 && h[n-1]>=h[n-2]) h[n-1]-h[n-2] else 0
  
  for(i in 1..n-2){ //왼오
    result += if (h[i]>=h[i-1]) h[i]-h[i-1] else 0
    result += if (h[i]>=h[i+1]) h[i]-h[i+1] else 0
  }
  bw.write("${result}")
  bw.flush()
  bw.close()
}
