import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.math.BigInteger
import kotlin.math.*
//1620 
//Todo. 해시에서 키를 두개 이상 사용하는 경우 
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  var nm = br.readLine().split(' ')
  var name = HashMap<String, Int>() //이름과 번호는 둘다 key역할임
  var num = HashMap<Int, String>()
  for(i in 1..nm[0].toInt()){
    var s = br.readLine()
    name[s]=i
    num[i]=s
  }
  for(i in 1..nm[1].toInt()){
    var s = br.readLine()
    if(name.contains(s)){
       bw.write("${name[s]}\n")
    }else{
      bw.write("${num[s.toInt()]}\n")
    }
  }

  bw.flush()
  bw.close()
}

