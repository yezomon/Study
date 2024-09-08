import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 11059
// Todo. 오래걸려서 풀었음. 나중에 다시풀기 
//  S의 연속된 부분 문자열 중에서 길이가 짝수이고, 앞의 절반의 합과 뒤의 절반의 합이 같은 부분 문자열을 크리 문자열이라고 한다. 빈 문자열은 크리 문자열이 아니다.S의
// 크리 문자열 중에서 가장 길이가 긴 것을 찾는 프로그램
/*
67896789 답8
6789789 답6
6789678 답4
S는 숫자로만 이루어져 있으며, 길이는 1,000을 넘지 않는다
Todo. 최소 2 부터 최대 size/2까지

*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    // var n = br.readLine().toInt()
    val a = br.readLine().map { it.code - '0'.code }
    var sum = Array(a.size) { 0 } // mutableListOf<Int>()
    sum[0] = a[0]
    var max_s = Integer.MIN_VALUE
    // 누적합
    for (i in 1..a.size - 1) {
        sum[i] = a[i] + sum[i - 1]
    }
    // 2 01,23 / 12,34/ 2345 / 3456 / 4567
    // 4 0123,4567
    // 6 012345,67..89
    var len = 0
    while (len < a.size / 2) {
        len += 1
        for (i in 0..a.size - 2 * len) {
            var v1 = sum[i + len - 1] - (if (i > 0) sum[i - 1] else 0)
            var v2 = sum[i + 2 * len - 1] - sum[i + len - 1] // (if (i > 0) sum[i+len-1] else 0)
            //bw.write("${len} ${i} ${v1} ${v2}\n")
            if (v1 == v2) {
                max_s = if (max_s < len) len else max_s
                break
            }
        }
    }
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
    //bw.write(sum.toList().joinToString(" ") + "\n")
    bw.write("${2*max_s}")
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
