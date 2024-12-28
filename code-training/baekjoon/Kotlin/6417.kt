import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 6417
/*
25
30
3121
-1
*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  //var n = br.readLine().toInt() //.split(" ").map { it.toInt() } //t x m 
  //var m = TreeMap<Int, Int>()
  // bw.write(m.toList().joinToString() + "\n")
  // val result = arr3.flatten().count { it == 1 }
  while(true){
    var n = br.readLine().toInt()
    if(n==-1) break
    var max_ = -1
    for(i in 1..n){
      var b = monkey(n, i)
      if(b&&i>1) max_= i //bw.write("$n $i\n")
    }
    if(max_>0) bw.write("$n coconuts, $max_ people and 1 monkey\n") else bw.write("$n coconuts, no solution\n")
  }
  bw.flush()
  bw.close()
}

fun monkey(r: Int, k: Int): Boolean {
    var curr = r

    // k명이 차례로 나누는 과정
    repeat(k) {
        if (curr <= 0 || (curr - 1) % k != 0) return false
        curr = curr - (curr - 1) / k - 1  // 원숭이에게 1개 주고 1/k만큼 가져감
    }

    // 마지막 분배
    return curr % k == 0 && curr >= 0
}
