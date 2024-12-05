import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.* 

// 18242
//  정사각형의 색칠하지 않은 한 변이 왼쪽, 오른쪽, 위쪽, 아래쪽일 때에 따라 각각 LEFT, RIGHT, UP, DOWN을 출력한다.
// 두 번째 줄부터 N개의 줄에 길이가 M인 문자열이 주어진다. i+1번째 줄의 j번째 문자가 ‘ # ’ 일 경우 색칠한 칸, ‘ . ’ 일 경우 색칠하지 않은 칸을 나타낸다.
// 격자가 그려진 흰색 바탕의 N × M 직사각형의 내부에 한 변의 길이가 3보다 큰 홀수이며 행 또는 열에 평행인 단 하나의 정사각형의 테두리를 색칠한다.
//이때 정사각형의 네 변 중 한 변의 가운데는 색칠하지 않으며 이 색칠하지 않은 변이 정사각형의 어느 변인지를 맞추어 보라는 것으로 시력 검사를 진행한다.
// (5 ≤ N, M ≤ 100)
/*
7 8
........
........
..#####.
..#...#.
..#.....
..#...#.
..#####.
RIGHT
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    //val marked = mutableSetOf<Int>() // 빈 집합으로 시작
    var nm = br.readLine().split(' ') //세로 가로
    var array = Array(nm[0].toInt()) { Array(nm[1].toInt()){""}}
    
    for (i in 0..nm[0].toInt()-1) {
        var s = br.readLine()
        array[i] = s.map{it.toString()}.toTypedArray() //s.map { it.toInt() }.toIntArray()
    }
    
    //bw.write("$result")
    //bw.write(array.joinToString("\n") { it.joinToString(" ") } + "\n")
    var cnt = 0
    var starti = nm[0].toInt()
    var endi = -1
    var j = nm[1].toInt()
    for(i in 0..nm[0].toInt()-1){
        //bw.write(array[i].joinToString()+"\n")
      if(array[i].any {it == "#"}){
          starti = min(i,starti) 
          endi = max(i,endi)
          j = min(array[i].indexOf("#"),j) 
         // bw.write("i:$starti ei:$endi j:$j \n")
      }
      
      cnt = max(array[i].count{it=="#"},cnt)
      //bw.write(array[i].count{it=="#"}.toString() + "\n")
      
    }
    //bw.write("size:$cnt\n")
    var result = if (array[starti].count{it=="#"} < cnt) "UP" 
    else if (array[endi].count{it=="#"} < cnt) "DOWN"
    else if((starti..endi).all{it->array[it][j]=="#"}) "RIGHT"
    else "LEFT"
    bw.write("$result") 
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
    
    //세로 줄 체크
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
