import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//10818
fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val t = br.readLine().toInt()

  val input = br.readLine() // 줄바꿈 기준으로 넘어감
  val newTestString = input.split(" ").map{it.toInt()}.toIntArray()
  newTestString.sort()
  //bw.write(newTestString.contentToString())
  bw.write(newTestString[0].toString()+" "+newTestString[t-1].toString())
  bw.flush()
  bw.close()

}