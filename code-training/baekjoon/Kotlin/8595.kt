import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import kotlin.text.toInt

// 8595
// with claude 
/*
단어와 히든 넘버는 아래와 같은 성질을 갖는다.

연속된 숫자는 한 히든 넘버이다.
두 히든 넘버 사이에는 글자가 적어도 한 개 있다.
히든 넘버는 6자리를 넘지 않는다.
14
ab13c9d07jeden
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))

  // val marked = mutableSetOf<Int>() // 빈 집합으로 시작
  var n = br.readLine().toInt()
  // var array = Array(nm[0].toInt()) { Array(nm[1].toInt()){""}}
  var text = br.readLine()
  //val text = "ab13c9d07jeden"
  var index = 0
  var result = 0L
  while (index < n) {
    if (text[index].isDigit()) {
      // 현재 위치에서 연속된 숫자 찾기
      var numLength = 1
      var currentIndex = index + 1

      // 다음 문자가 숫자인지 확인 (최대 6자리까지)
      while (currentIndex < text.length && text[currentIndex].isDigit() && numLength < 6) {
        numLength++
        currentIndex++
      }

      if (numLength > 0) {
        // substring으로 연속된 숫자 추출
        val number = text.substring(index, index + numLength)
        //println("연속된 숫자: $number")
        //println("위치: $index")
        //println("길이: $numLength")
        result += number.toLong()
      }
      index += numLength
    } else {
      index++
    }
  }

  // var ix = if (s.indexOf("0")>s.indexOf("1")) s.indexOf("0") else s.indexOf("1")
  // var num = s[ix].code -'0'.code

  // bw.write("$ix $num $rev $fac \n")
  // array[i] = s.map{it.toString()}.toTypedArray() //s.map { it.toInt() }.toIntArray()

  bw.write("$result")
  // bw.write(array.joinToString("\n") { it.joinToString(" ") } + "\n")
  // var cnt = 0
  // var starti = nm[0].toInt()
  // var endi = -1
  // var j = nm[1].toInt()
  // for(i in 0..nm[0].toInt()-1){
  //     //bw.write(array[i].joinToString()+"\n")
  //   if(array[i].any {it == "#"}){
  //       starti = min(i,starti)
  //       endi = max(i,endi)
  //       j = min(array[i].indexOf("#"),j)
  //      // bw.write("i:$starti ei:$endi j:$j \n")
  //   }

  //   cnt = max(array[i].count{it=="#"},cnt)
  //   //bw.write(array[i].count{it=="#"}.toString() + "\n")

  // }
  // //bw.write("size:$cnt\n")
  // var result = if (array[starti].count{it=="#"} < cnt) "UP"
  // else if (array[endi].count{it=="#"} < cnt) "DOWN"
  // else if((starti..endi).all{it->array[it][j]=="#"}) "RIGHT"
  // else "LEFT"
  // bw.write("$result")
  // for(i in 0..nm[0].toInt()-1){
  //   cnt = max(array[i].count{it=="#"},cnt)
  //   bw.write(array[i].count{it=="#"}.toString() + "\n")
  // }

  // 가로 줄 체크
  // for (i in 0..4) {
  //     if (array[i].all { it in marked }) {
  //         bingoCount++
  //     }
  // }

  // 세로 줄 체크
  // for (i in 0..4){
  //     if((0..4).all{it->array[it][i] in marked}){
  //         bingoCount++
  //     }
  // }

  // //대각선 체크 오왼
  // if((0..4).all{i->array[i][i] in marked}) {
  //     bingoCount++
  // }

  // val treeSet = TreeSet<String>().apply {
  //     addAll(s)
  //     addAll(s2)
  // }
  // bw.write(treeSet.joinToString()+'\n')

  // for(a in treeSet){
  //     for(b in treeSet){
  //         bw.write("$a $b\n")
  //     }
  // }

  // var arr: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
  // var arrB: Array<Array<Boolean>> = Array(n) { Array(n) { false } }
  // for (i in 0..n - 1) {
  //     arr[i] = br.readLine().split(' ').map { it.toInt() }.toTypedArray()
  // }

  // val a = br.readLine().map { it.code - '0'.code }
  // var sum = Array(a.size) { 0 } // mutableListOf<Int>()

  // val a = br.readLine().split(' ').map { it.toLong() } // Ai >= Bi  (1 ≤ Aᵢ Bᵢ ≤ 1018
  // val b = br.readLine().split(' ').map { it.toLong() }.toList() // 오름차순
  // val ai = br.readLine().split(' ').map { it.toLong() }.toMutableList()
  // var arr = ArrayList<Pair<Int, Long>>(n + 1) // // MutableList<Int>(nk[0]) { 0 }
  // arr.addAll(ai)
  // var map = mutableMapOf<Long, Int>()
  // for (i in 0..n-1) {
  //   map[b[i]] = i
  //   // if(map.containsKey(b[i])){
  //   //     map[b[i]] = i
  //   // }
  //   //arr.add(Pair(i, b[i])) //a 인덱스, 자신보다 큰값이 나타나는 b의 인덱스
  // }
  // bw.write(map.toList().joinToString(" ") + "\n")
  // for (i in 1..nk[0] - 1) {
  //   arr[i] = Pair(arr[i].first, arr[i].second + arr[i - 1].second)
  // }
  // arr.sortWith { a, b -> b.second.compareTo(a.second) }
  // ai.sortWith{a,b->b.compareTo(a)} //{a,b->b-a} illegal exception
  // var result = ai.take(nk[0]).sumOf { it }//ai.take(nk[1]).sumOf { it }
  // var p = s.toMutableList().sortedDescending().take(t[1]).toTypedArray().sumOf { it }
  // var sub = arr.take(nk[0]).subList(0, nk[1])
  // var ssub = sub.sortedWith { a, b -> a.first.compareTo(b.first) }
  bw.flush()
  bw.close()
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
// fun findM() : Boolean{
// }
