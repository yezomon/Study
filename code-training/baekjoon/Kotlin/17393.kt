import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


// 17393
//  자연수 N이 입력으로 주어진다. (1 ≤ N ≤ 500,000)
//  다이나믹 롤러로 현재 위치보다 오른쪽에 있으면서 점도지수 B 가 서 있는 칸의 잉크지수 Ai 이하인 칸을 칠할 수 있다.
/*
6
60 90 100 88 90 99
60 70 80 85 90 90
출력 0 4 3 0 1 0

i번쨰 타일에 대한 답은 i부터 N까지 중에 자신보다 큰값이 나타나는  답=(인덱스-1)-i 
맵을 쓴다고해도 해당 값이 없을 경우 가장가까운 값이 뭔지 모르기때문에 결과는 같음 .-> 힌트 : 이분탐색. 
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var n = br.readLine().toInt()
    val a = br.readLine().split(' ').map { it.toLong() } // Ai >= Bi  (1 ≤ Aᵢ Bᵢ ≤ 1018
    val b = br.readLine().split(' ').map { it.toLong() }.toList() // 오름차순
    // bw.write("${result}")
    // val ai = br.readLine().split(' ').map { it.toLong() }.toMutableList()
    //var arr = ArrayList<Pair<Int, Long>>(n + 1) // // MutableList<Int>(nk[0]) { 0 }
    // arr.addAll(ai)
    //var map = mutableMapOf<Long, Int>()
    // for (i in 0..n-1) {
    //   map[b[i]] = i
    //   // if(map.containsKey(b[i])){
    //   //     map[b[i]] = i
    //   // }
    //   //arr.add(Pair(i, b[i])) //a 인덱스, 자신보다 큰값이 나타나는 b의 인덱스
    // }
    //bw.write(map.toList().joinToString(" ") + "\n")
    var results = mutableListOf<Int>()
    for (i in 0..n - 1) {
        var result = b.binarySearchRightmost(a[i])  //b.binarySearch(a[i])

        if (result > 0){ //특정값이 있음. 
            //bw.write("${i}a${result}\n") 
            results.add(result-i)
            continue;
        }else if(result < 0 ) { //특정값이 없음. 
            result = (result + 1) * -1
            //bw.write("${i}b${result}\n") 
            if(result > n-1){
                //result = n-1
            }
            results.add(result-i-1)
        }else{
            //bw.write("${i}c${result}\n") 
            results.add(0)
        }
    }
    bw.write(results.toList().joinToString(" "))
    // for (i in 1..nk[0] - 1) {
    //   arr[i] = Pair(arr[i].first, arr[i].second + arr[i - 1].second)
    // }
    // arr.sortWith { a, b -> b.second.compareTo(a.second) }
    // ai.sortWith{a,b->b.compareTo(a)} //{a,b->b-a} illegal exception
    // var result = ai.take(nk[0]).sumOf { it }//ai.take(nk[1]).sumOf { it }
    // var p = s.toMutableList().sortedDescending().take(t[1]).toTypedArray().sumOf { it }
    // var sub = arr.take(nk[0]).subList(0, nk[1])
    // var ssub = sub.sortedWith { a, b -> a.first.compareTo(b.first) }
    // bw.write("${arr}\n")
    // bw.write("${ssub}\n")
    // bw.write("${ai}\n")
    bw.flush()
    bw.close()
}

fun <T : Comparable<T>> List<T>.binarySearchRightmost(target: T): Int {
    var left = 0
    var right = size - 1
    var result = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val midValue = this[mid]

        when {
            midValue > target -> right = mid - 1
            midValue < target -> left = mid + 1
            else -> {
                // 타겟을 찾았지만, 오른쪽에 더 있을 수 있으므로 계속 탐색
                result = mid
                left = mid + 1
            }
        }
    }

    return if (result == -1) -(left + 1) else result //return result
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
// fun findM() : Boolean{
// }
