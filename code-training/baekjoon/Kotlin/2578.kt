import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// with claude
// 2578
//  첫째 줄에 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
/*
첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수가 가장 위 가로줄부터 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 여섯째 줄부터 열째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩 빈 칸을 사이에 두고 주어진다. 빙고판에 쓰여진 수와 사회자가 부르는 수는 각각 1부터 25까지의 수가 한 번씩 사용된다.
11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var array = Array(5) { IntArray(5)}
    var array2 = Array(5) { IntArray(5)}
    val marked = mutableSetOf<Int>() // 빈 집합으로 시작

    for (i in 0..4) {
        var s = br.readLine().split(' ')
        array[i] = s.map { it.toInt() }.toIntArray()
    }

    for(i in 0..4){
        var s2 = br.readLine().split(' ')
        array2[i] = s2.map{it.toInt()}.toIntArray()

    }

    var result = 0
    var bingoCount = 0 
    for(i in 0..4){
        if (bingoCount>=3) {break}
        for(j in 0..4){
            result++
            marked.add(array2[i][j])
            bingoCount = checkBingo(array, marked)
            //bw.write("$bingoCount\n")
            if (bingoCount>=3) {break}
        }
    }
    bw.write("$result")
    //bw.write(array.joinToString("\n") { it.joinToString(" ") } + "\n")


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

fun checkBingo(array:Array<IntArray>, marked:Set<Int>) : Int{
    var bingoCount = 0

    // 가로 줄 체크
    for (i in 0..4) {
        if (array[i].all { it in marked }) {
            bingoCount++
        }
    }

    //세로 줄 체크
    for (i in 0..4){
        if((0..4).all{it->array[it][i] in marked}){
            bingoCount++
        }
    }

    //대각선 체크 오왼
    if((0..4).all{i->array[i][i] in marked}) {
        bingoCount++
    }

    //대각선 체크 왼오
    if((0..4).all{i->array[i][4-i] in marked}) {
        bingoCount++
    }

    return bingoCount;
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
