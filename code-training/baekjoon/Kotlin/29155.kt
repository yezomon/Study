import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 각 문제와 문제 사이에는 휴식 시간이 필요한데 이는 만약 두 문제가 같은 난이도라면 두 문제를 푸는 데 걸리는 시간의 차이만큼 필요하고 난이도를 증가시키는 경우
// 60분의 시간이 필요하다. 즉, 구름이가 문제를 푸는 데 걸리는 시간은 푼 문제의 예상 시간 합과 문제 사이 휴식 시간의 합만큼 걸린다.
// 29155
//Todo. 난이도가 1~5라서 처음 5로 리스트크기를 잡았지만 난이도 크기 범위가 엄청크거나 알수없다면?
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))

  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()

  val n = br.readLine().toInt()
  val tosolve = br.readLine().split(' ').map { it.toInt() } // 난이도1~5까지 풀어야할문제 수
  val dl: MutableList<MutableList<Pair<Int, Boolean>>> =  MutableList(5) { mutableListOf() }//mutableListOf()
  // Array(n) { Array(2){0} } //난이도별 문제푸는 시간. 나열.
  // Reading the next n numbers and pairing them with sequence values
  for (i in 1..n) {
    val m = br.readLine().split(' ').map { it.toInt() }
    //val row: MutableList<Pair<Int, Boolean>> = mutableListOf()
    //row.add(Pair(m[1], false))
    dl[m[0]-1].add(Pair(m[1],false))
   // dl.add(row)
    //bw.write(dl.joinToString(" ") + "\n")
    // pairList.add(Pair(i, m))
  }
  dl.forEach { row -> row.sortBy { it.first } }
  bw.write(dl.joinToString(" ")+"\n")
  var answer = 0
  // 2359   2132549->3599
  for(row in dl){
    val Pairs1 = row.take(tosolve[dl.indexOf(row)]).toMutableList()
    Pairs1.sortByDescending{it.first}
    answer += Pairs1.take(tosolve[dl.indexOf(row)]-1).sumOf { it.first }
    answer +=  Pairs1.take(1).sumOf { it.first }
    bw.write(Pairs1.joinToString(" "))
    // for(pair in row){

    // }
  }
  // val Pairs1 = dl[0].take(tosolve[0]).toMutableList()
  // Pairs1.sortByDescending{it.first}
  // answer += Pairs1.take(tosolve[0]-1).sumOf { it.first }
  // answer +=  Pairs1.take(1).sumOf { it.first }
  bw.write("${answer+240}\n")



  // Sorting the pair list by the second element of the pairs in descending order
  // pairList.sortByDescending { it.second }
  // Taking the top 5 pairs
  // val top5Pairs = pairList.take(5)
  // var answer = top5Pairs.sumOf { it.second }
  // bw.write("${answer}\n")
  // Extracting the first elements of the top 5 pairs and sorting them
  // val top5FirstElements = top5Pairs.map { it.first }.sorted()
  // Printing the sorted first elements
  // bw.write(top5FirstElements.joinToString(" "))
  bw.flush()
  bw.close()
}
