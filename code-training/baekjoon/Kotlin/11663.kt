import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import kotlin.text.toInt

// Todo. 이분탐색. 처음에 주석된 부분 풀고 break 하다가 시간초과 났었는데, 그부분 빼고 result 계산 하는 부분 claude한테 물어봐서 바꾸고 선분 끝점 계산할때 조건에 = 추가했더니 시간초과가 해결됐음. 
// 11663
/*
일차원 좌표상의 점 N개와 선분 M개가 주어진다. 이때, 각각의 선분 위에 입력으로 주어진 점이 몇 개 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N과 선분의 개수 M이 주어진다. (1 ≤ N, M ≤ 100,000) 둘째 줄에는 점의 좌표가 주어진다. 두 점이 같은 좌표를 가지는 경우는 없다. 셋째 줄부터 M개의 줄에는 선분의 시작점과 끝점이 주어진다. 입력으로 주어지는 모든 좌표는 1,000,000,000보다 작거나 같은 자연수이다.
5 5
1 3 10 20 30
1 10
20 60
3 30
2 15
4 8
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
   val br = BufferedReader(InputStreamReader(System.`in`))
   val bw = BufferedWriter(OutputStreamWriter(System.out))

  val (n, m) = br.readLine().split(' ').map { it.toInt() }
   var p = br.readLine().split(' ').map{it->it.toLong()}
   //var arr = LinkedList<Pair<Int,Pair<Long,Long>>>() 
   //var indexedArr = LinkedList<Pair<Long,Long>>()
   val lines = Array(m) { 
        val (start, end) = br.readLine().split(' ').map { it.toLong() }
        Pair(start, end)
    }
  //  for(i in 0..nm[1].toInt()-1){
  //    var s = br.readLine().split(' ')
  //    arr.add(Pair(i,Pair(s[0].toLong(),s[1].toLong())))
  //    indexedArr.add(Pair(s[0].toLong(),s[1].toLong()))
  //  }
  // arr.sortWith(compareBy { it.second.first }) //arr.sortWith { a, b -> a.second.first - b.second.first } 
   //println(arr.joinToString())
   //println(indexedArr.joinToString())
   p = p.sorted()
  
   for(i in 0..m-1){ //각 선분에 (시작점) 대해서, 점 리스트에서의 위치. 
     var v = lines[i].first//arr[i].second.first 
     var st = 0
     var end = p.size-1
     var cnt = 0
     var mid = 0
     //bw.write("===============$i\n")
     while(st<=end){
        mid = (st+end)/2
        //bw.write("$st $mid $end\n")
        if(p[mid]<v){
          st = mid+1
        }else{
          end = mid-1
        }
        // else if(p[mid]>v){
        //   end = mid-1
        // }else{
        //   //cnt++
        //   //bw.write("$mid cnt:$cnt\n")
        //   //break
        // }
      }
      //bw.write("$st | $end\n")
      var v2 = lines[i].second
      var st2 = 0
      var end2 = p.size-1
      var mid2 = 0
      while(st2<=end2){
         mid2 = (st2+end2)/2
        //bw.write("$st2 $mid2 $end2\n") 
        if(p[mid2]<=v2){
          st2 = mid2+1
        }else{
          end2 = mid2-1
        }
        // }else if(p[mid2]>v2){
        //   end2 = mid2-1
        // }else{
        //   //cnt++
        //   //bw.write("$mid2 cnt:$cnt\n")
        //   //break
        // }
      }
      //bw.write("$st2 | $end2\n")
     var result = end2-st+1
      bw.write("$result\n")
   }

   bw.flush()
   bw.close()
}
