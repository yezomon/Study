import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

//소팅 sort 여러기준 정렬 
// 15905
/*
5
7 620
4 500
2 420
5 300
4 510
7
7 620
4 500
2 420
5 300
4 510
5 420
4 340
7
4 620
4 500
4 420
4 300
4 510
4 440
4 340
*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt() // .split(" ").map { it.toInt() } //t x m
  // var m = TreeMap<Int, Int>()
  // bw.write(m.toList().joinToString() + "\n")
  // val result = arr3.flatten().count { it == 1 }
  var arr = LinkedList<Pair<Int, Int>>()
  for (i in 0..n - 1) {
    var s = br.readLine().split(' ')
    arr.add(Pair(s[0].toInt(), s[1].toInt()))
  }

  // arr.sortWith(
  //     compareBy<Pair<Int, Int>>({ it.first }) //오름차순
  //     .thenByDescending({ it.second }) //내림차순
  //     // .thenBy({ it.third })
  //     // .thenByDescending({ it.fourth })
  //     )

  arr.sortWith(compareByDescending<Pair<Int, Int>>({ it.first }).thenBy({ it.second }))

  //bw.write(arr.joinToString() + "\n")

  // 5등의 문제 수 찾기
  val fifth = arr[4].first
  val count = arr.drop(5).count { it.first == fifth }

  bw.write("$count") 
  bw.flush()
  bw.close()
}
