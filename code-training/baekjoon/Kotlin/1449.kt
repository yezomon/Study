import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.* 

// 1449
//  항승이는 품질이 심각하게 나쁜 수도 파이프 회사의 수리공이다. 항승이는 세준 지하철 공사에서 물이 샌다는 소식을 듣고 수리를 하러 갔다.
// 파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다.
// 항승이는 길이가 L인 테이프를 무한개 가지고 있다.
// 항승이는 테이프를 이용해서 물을 막으려고 한다. 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.
// 물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오. 테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.
// 첫째 줄에 물이 새는 곳의 개수 N과 테이프의 길이 L이 주어진다. 둘째 줄에는 물이 새는 곳의 위치가 주어진다. N과 L은 1,000보다 작거나 같은 자연수이고, 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수이다.
/*
4 2
1 2 100 101
//2
4 3
1 2 3 4
//2
3 1
3 2 1
//3
5 1
1 2 3 4 5
7 5
1 2 3 4 5 6 100
3
5 5
1 2 3 4 5
// 1 
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    //val marked = mutableSetOf<Int>() // 빈 집합으로 시작
    var nl = br.readLine().split(' ').map{it.toInt()}.toIntArray() //N L
    var nums = br.readLine().split(' ').map{it.toInt()}.toIntArray()
    Arrays.sort(nums)
    // bw.write(array.joinToString()+"\n")
    var term = 0
    var result = 1
    for(i in 1..nl[0].toInt()-1){
      if( term+(nums[i]-nums[i-1] ) <= nl[1].toInt()-1){ //테이프길이-1 
         term += nums[i]-nums[i-1]
         //bw.write("t:$term $i\n")
      }else { 
        term=0 
        result++
      }
    }
    
    bw.write("$result")
    bw.flush()
    bw.close()
}
