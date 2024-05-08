import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// import kotlin.math.*
// 1120
// Todo. // a랑 b 차이가 3일때  앞뒤뒤 앞앞뒤 앞뒤앞 3가지 경우 찾기 -> 숫자 2개로 3줄세우기
// -> 위에꺼아님.  앞 갯수 와 뒷 갯수 기준으로 생각하면됨. -->  숫자 2개 를 가지고 만든 합 == 문자열 a,b의 차이
// -> 이것을 최소로 하는것.
// 문자 길이차이가 n일때 숫자 2개로 합 n(문자열 a,b의차이) 만드는 모든 경우를 비교하기 (브루트포스)
// 응용버전) 숫자가 2개가 아닌 k개 라면 그 갯수만큼 for문이 중첩됨 --> 브루트포스로 안될듯 ->백트래킹..?

data class Node(var y: Int, var value: String, var date: Int)

fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
  // var ss = br.readLine().split(' ')
  // var n = ss[0].toInt()
  // var min = -1
  // var sums:Array<Int> = Array<Int>(n,{0})

  var n = br.readLine().toInt()
  var people = HashMap<String, Int>() //TreeSet과 차이점..? 
  for(i in 0..n-1){
    var s = br.readLine().split(' ')
    if(people.containsKey(s[0])){
      people.remove(s[0])//people[s[0]] = 0 //퇴장
    }else{
      people[s[0]] = 1 //입장 
    }
  }
  var keys = people.keys.toList().sorted().reversed()

  //var values = people.values.toList()
  for(i in 0..keys.size-1){
    bw.write("${keys[i]}\n")
  }
  /*
  var arr = Array<Node?>(s) { null }
  for (i in 0..s - 1) {
    var ss = br.readLine().split(' ')
    arr[i] = Node(ss[0].toInt(), ss[1], i)
  }
  arr.sortWith(compareBy({ it?.y }, { it?.date }))
  arr.forEach { bw.write("${it?.y} ${it?.value}\n") }
*/
  /* var last = 0
  for (i in 0..a.length-1) {
    if(n-i<0){
      continue
    }
   // bw.write("${n-i} ${i}\n")
   bw.write("${a[i]} ${b[n-i]}\n")
    if(a[i]!=b[n-i]){
      last++
    }
  }
  bw.write("last${last}\n")*/

  /*
  if(s[i] < min){
    minV = min(minV,s[i])
  }
  if(s[i] > max){
    maxV = max(maxV,s[i])
  }*/

  /*
  if( answer == Integer.MAX_VALUE){
    bw.write("${-1}")
  }else{
    bw.write("${answer}")
  }
  for(i in 0..n-1){ //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
    //answer += k/arr[n-1-i]
    //k%=arr[n-1-i]
    //bw.write("${arr[i]}\n")
  }*/

  /*
    var answer : Int = 0
    for(i in 0..t-1){
      answer += s[i].digitToInt()
     //bw.write("${s[i].code}\n")
    }
  */

  /*var dir =
  arrayOf(
      arrayOf(0, 1),
      arrayOf(1, 0),
      arrayOf(-1, 0),
      arrayOf(0, -1)
  )*/
  // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  // bw.write(numList.joinToString())
  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}
