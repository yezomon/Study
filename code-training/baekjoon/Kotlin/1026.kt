import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.*

// 1026
fun main() {
  // println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt() // split(" ")
  // var n = s[0].toInt() //10
  // var coin:Array<Int> = arrayOf(25,10,5,1)
  // var answer : Int = Integer.MAX_VALUE
  //var arrA: Array<Int> = Array<Int>(n, { 0 })
  var a:Array<Int> = br.readLine().split(' ').map({ it.toInt() }).toTypedArray()
  var b = br.readLine().split(' ').map({ it.toInt() }).toTypedArray()
  a.sortWith(compareBy({it}))
  b = b.sorted().reversed().toTypedArray()
  //bw.write("${a.joinToString()}\n")
  //bw.write("${b.joinToString()}\n")
  var answer = 0
  for (i in 0..n - 1) {
    answer += (a[i]*b[i])
  }
  // for(i in 0..n-1){  //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
  //   //answer += k/arr[n-1-i]
  //   //k%=arr[n-1-i]
  //   //bw.write("${arr[i]}\n")
  // }
  bw.write("${answer}")
  bw.flush()
  bw.close()
}
