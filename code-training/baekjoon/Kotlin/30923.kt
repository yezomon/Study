import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
3
3 1 2
답 : 3 + 3/ + 3 + 2 + 0 + 0 + 1 + 2 +/ 3 + 1 + 2 + 3 + 1 + 2
6 8 12 = 26
3
1 2 3
답 : 3 + 3 / 1+0+1+0+1+3/123123
6 6 12 = 24
윗면아래면 왼오반복 앞면뒷면
*/
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
