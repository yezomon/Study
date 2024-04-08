import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
//10250
//(1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W). 
/*
2
6 12 10
30 50 72

4
10 5 25
6 3 16
8 4 8
8 5 9

Input : 
1
1 12 2
Output : 101
Answer : 102

1
5 9 45

Output: 59
Answer: 509

입력
1
3 10 28

출력
1010

정답
110
*/
fun main() {
  //println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))

  var t =  br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var max: Int = -1
  for (i in 1..t) {
    var s = br.readLine().split(" ")
    var h = s[0].toInt()
    //var w = s[1].toInt()
    var n = s[2].toInt()
    var value = n/h
    var mod = n%h
    //호수 = 몫   나머지 = 층 
    //bw.write("${mod}wwww${value}\n")
    //나머지가 있음 = 호수 1증가 
    //나머지 없음 = 호수 출력 
    
    if (mod>0) { //나머지가 있는 한자리수 호수
      bw.write("${mod}")
      value++
    }else if(mod==0){ //나머지 없음  한자리수 호수
      bw.write("${h}")
    }

    if((10-value)>0){ // 한자리수 
       bw.write("0${value}")
    }else{ //두자리수
      bw.write("${value}")
    }
    
    if (i!=t){
      bw.write("\n")
    }
    //bw.write("${s[0]} ${s[1]}\n")
  }
  //bw.write("$max\n")
  bw.flush()
  bw.close()
}
