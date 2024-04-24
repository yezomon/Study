import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 2839
// 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.  봉지의 최소 개수를 출력
// Todo. 백트레킹일줄알았는데 dp/그리디라고 하는데 왜?  https://www.acmicpc.net/board/view/118398 이글 보고 따라서만듬.
/*
18 
4
--
11 
3
--
4
-1
--
6
2
--
9
3
--추가
7
-1
--
8
2
--
12
4
*/
//data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()
  //var arr:Array<Int> = Array<Int>(n,{0})
  var answer : Int = Integer.MAX_VALUE//-1
  
  //5의 최대갯수 n/5부터 0까지 
  var f = n/5
  while( f >= 0){ //5의 갯수를 최대한 크게하는 구현법 : https://www.acmicpc.net/board/view/118398
    var count = f
    var t = n-f*5 //나머지 
    if( t % 3 == 0 ){ //3의 갯수 
      count += t/3 
      if(answer > count){ //왜 이게 필수인가 
        answer = count
      }
    } 
    f--
   // n %= 5
  }
  if( answer == Integer.MAX_VALUE){
    bw.write("${-1}")
  }else{
    bw.write("${answer}")
  }
  /*for(i in 0..n-1){ //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
    //answer += k/arr[n-1-i]
    //k%=arr[n-1-i]
    //bw.write("${arr[i]}\n")
  }*/


  /*if(t%5!=0 || t%3!=0 || t%3!=5 || t%5!=3 || t%8!=3 || t%8!=5){
    bw.write("${-1}")
  }*/

  /*var s = br.readLine()
  var answer : Int = 0
  for(i in 0..t-1){
    answer += s[i].digitToInt()
   //bw.write("${s[i].code}\n")
  }
  bw.write("${answer}")*/
  
  // var arr: Array<Int> = Array<Int>(10001, { 0 })
  /*var dir =
      arrayOf(
          arrayOf(0, 1),
          arrayOf(1, 0),
          arrayOf(-1, 0),
          arrayOf(0, -1)
      )*/ // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  // bw.write(numList.joinToString())
  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}


