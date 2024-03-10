import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 2440
// 조건 : 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
// 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력
fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val t = br.readLine().toInt()
  for(i in 1..t) {
    for(j in 1..t-i+1){ 
      bw.write("*")
    }
    for(j in t-i+1..t){  
      //bw.write("*")
    }
    bw.write("\n")
    //val input = br.readLine() // 줄바꿈 기준으로 넘어감 
    //bw.write("$a\n")
  }
          /* for(i in 1..t) {
            val input = br.readLine() // 줄바꿈 기준으로 넘어감
            val newTestString = input.split(" ")
            bw.write("\n")
            //val input = br.readLine() // 줄바꿈 기준으로 넘어감
            //val newTestString = input.split(" ")
            //var a = newTestString[0].toInt() +  newTestString[1].toInt()
            //bw.write("$a\n")
          }*/
          bw.flush()
  bw.close()
  // 공백(띄어쓰기) 기준으로 잘라줌
  // val newTestString = input.split(" ")
  // println(newTestString)
  // println(newTestString[0])
  // println(newTestString[1])
  // val input = br.readLine()
  // var t = input.toInt()
  // var a = 0
  // for (i in 1..t) {
  //   var s = i.toString()
  //   for (j in 0..s.length-1){
  //     if (s[j] == '1'){
  //       a++
  //     }
  //   }

  // }
  // bw.write("$a\n")
  // println("$input " + input?.length)
  // bw.write("$input\n"+ input?.length+" \n")

}
