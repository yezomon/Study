import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 10917
// Think > 그래프 최단경로? 왜 여긴 너비 우선탐색인가? 왜 깊이 우선탐색은 안되나? 
/*
당신이 꿈을 이루는 과정 중에 일어날 수 있는 수많은 상황들의 관계를 그래프로 나타내어 보겠다. 많은 상황을 압축해서 N개의 상황이 일어날 수 있다고 하고 1번에서 N까지의 번호를 붙였다. 당신은 현재 1번 상황에 있다. 그리고 N번 상황은 당신이 이루고자 하는 유일한 꿈이다.

상황은 당신의 선택에 따라 변화할 수 있다. 당신이 선택할 수 있는 변화는 총 M개 있으며 x, y의 형태로 주어진다. 이는 당신이 상태 x에 있는 경우 상태 y로 가는 선택을 할 수 있다는 것을 의미하며, x < y임이 보장된다.

당신은 꿈을 이룰 수 있을까? 이룰 수 있다면 당신의 상황이 변화하는 횟수를 최소한으로 줄이면 몇 번 만에 꿈을 이룰 수 있을까?

입력
첫 번째 줄에는 두 개의 자연수 N, M(0 ≤ M ≤ 200,000)이 주어진다.

이후 M개의 줄에는 두 개의 자연수 x, y(1 ≤ x < y ≤ N)가 공백으로 구분되어 주어진다

1 ≤ N ≤ 100,000인 입력이 주어진다.

출력
당신이 꿈을 이룰 수 있다면 꿈을 이루기 위해 필요한 상황 변화 수의 최솟값을 출력하고, 이룰 수 없다면 -1을 출력한다.

4개의 상황, 4개의 엣지
4 4
1 2
2 3
3 4
2 4
답 4
*/
fun main() {
  // println("Hello world!")

  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var br = BufferedReader(InputStreamReader(System.`in`))

  //var minCnt = 200000 
  var nm = br.readLine().split(' ').map { it.toInt() }.toIntArray()
  var array = Array(nm[0]+1){LinkedList<Int>()}//Array(nm[0] + 1) { Array(nm[0] + 1) { 0 } } //메모리초과 
  var queue : Queue<Int> = LinkedList<Int>()
  var distance :IntArray = IntArray(nm[0]+1) { -1 } // -1 은 미방문 
  
  for (i in 1..nm[1]) {
    var xy = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    array[xy[0]].add(xy[1]) 
    //bw.write(array[i].joinToString(" ") + "\n")
  }
  distance[1] = 0
  queue.add(1) //start 
  //for (i in 1..nm[0]){
    // for(j in 1..nm[0]){ // x<y보장 
    //   if(array[1][j] == 1){
    //     queue.add(j)
    //   }
    // }
    while(!queue.isEmpty()){
      var e = queue.poll()
      for(j in array[e]){ // x<y보장 
        if(distance[j] == -1 ){ //미방문
          distance[j] = distance[e]+1
          queue.add(j)
        }
      }
    }
    var result = distance[nm[0]]
    bw.write("$result")
  //}
  
  bw.flush()
  bw.close()
}
