import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 10828
/*
*/
//data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()
  //var arr:Array<Int> = Array<Int>(n,{0})
  //var answer : Int = Integer.MAX_VALUE//-1
  var st = LinkedList<Int>() //stack
  for(i in 1..n){
    var s = br.readLine().split(' ')
    if(s.size>1){
      //bw.write("${s[0]}\n")
      if(s[0]=="push"){
        st.push(s[1].toInt())
        //bw.write(st.joinToString()+"\n")
      }
    }else{
      if(s[0]=="top"){
        if(st.size>0){
          var sp = st.peek()
          bw.write("${sp}\n")
        }else{
          bw.write("${-1}\n")
        }
      }else if(s[0]=="size"){
        bw.write("${st.size}\n")
      }else if(s[0]=="empty"){
        if(st.size>0){
          bw.write("${0}\n")
        }else{
          bw.write("${1}\n")
        }
      }else if(s[0]=="pop"){
        if(st.size>0){
          var sp = st.pop()
          bw.write("${sp}\n")
        }else{
          bw.write("${-1}\n")
        }
      } 
    } 
  }

  bw.flush()
  bw.close()
}