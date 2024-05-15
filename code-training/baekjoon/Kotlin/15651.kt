import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// import kotlin.math.*
// 15651
//

//data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var m = s[1].toInt()
  var isUsedArr = Array<Boolean>(10,{false})
  var arr = Array<Int>(10,{0}) //왜10개
  BackTracking(0, n,m,isUsedArr,arr)
  //bw.write("${answer}")
  /*
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

  var values = people.values.toList()
  for(i in 0..keys.size-1){
    bw.write("${keys[i]}\n")
  }
  */
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

fun BackTracking(k:Int, n:Int, m:Int, isUsedArr:Array<Boolean>, arr:Array<Int>){
  //출력
  if(k==m){ //수열크기 m,  k는 트리의 depth이자 현재 채워진 수열의 숫자 갯수
    for(i in 0..m-1){
      bw.write("${arr[i]}")
      bw.write(" ")
    }
    bw.write("\n")
    return
  }
  //수열생성
  for(i in 1..n){
    if(isUsedArr[i]==false){
      arr[k] = i
      for(j in 1..i-1){
        //isUsedArr[j] = true
      }
     // isUsedArr[i] = true
      BackTracking(k+1,n,m,isUsedArr,arr)
      for(j in 1..i-1){
        //isUsedArr[j] = false
      }
      //isUsedArr[i] = false //???
    }
  }
}
