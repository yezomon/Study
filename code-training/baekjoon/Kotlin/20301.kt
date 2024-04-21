import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
import java.util.*

//20301 반전요세푸스
// 요세푸스 문제에 재미를 더하기 위해 M명의 사람이 제거될 때마다 원을 돌리는 방향을 계속해서 바꾸려고 한다. 
// 1<N<5000 1<K,M<N  3627154    원래3627514
// 7 3 4    1234567 71245 24571  145 
// TODO. 숫자가 만약 중복으로 주어질 경우, 응용할 수 있어야할듯 코틀린에서 큐의 마지막요소 제거하는법 알아보기.
// java Queue 인터페이스에 removeLast가 없어서 큐가 아닌 LinkedList로 바꿧음. 
fun main() {
  //println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var arr:Array<Int> = Array<Int>(n,{0})
   var s = br.readLine().split(" ")
   var n=s[0].toInt()
   var k=s[1].toInt()
   var m=s[2].toInt()
   var q :LinkedList<Int> = LinkedList<Int>()
   for(i in 1..n){
     q.add(i)
   }
  //var ts = TreeSet<Int>()
  var count = 1
  var mcount = 0
  //bw.write("<")
  var e : Int = 0
  var r : Int = 1
  while(q.size > 0){
    e = 0
    //bw.write(q.joinToString()+"ㄷㄷ\n")
    if (mcount>0 && (mcount%m)==0) {
      //bw.write("${mcount}mm${e}\n")
      //bw.write(q.joinToString()+"\n")
      r = r*-1
      mcount = 0
      //bw.write("queue! \n")
    }
    if(r<0){
       e = q.removeLast()
       //q.remove(e) //숫자중복일때 문제가 될수있다.
    }else {
      e = q.remove()
    }
    
    if(count%k==0){ 
      //bw.write(q.joinToString())
      //bw.write("queue! \n")
      bw.write("${e}")
      if(q.size>0){
          bw.write("\n")
      }
      mcount++
    }else if(r<0){
      q.addFirst(e)
    }else{
      q.add(e)
      //bw.write(q.joinToString())
      //bw.write("queue~ \n")
    }
    count++
  }
  //bw.write(">")
  bw.flush()
  bw.close()
}
