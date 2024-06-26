  import java.io.BufferedReader
  import java.io.BufferedWriter
  import java.io.InputStreamReader
  import java.io.OutputStreamWriter
  import java.util.*
  //1439
  //Todo. 코틀린 char.toInt()의 리턴값과  char.code는 전혀 리턴값이 다름. "1".toInt()는 1이, "1".code는 48인가 49나옴. 

  fun main() {
    // println("Hello world!")
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var s = br.readLine() //split(" ")
    s += "*"
    //var n = s[0].toInt() //10
    //var k = s[1].toInt() //4200
    //var coin:Array<Int> = arrayOf(25,10,5,1)
    //var answer : Int = Integer.MAX_VALUE 
     var arr:Array<Int> = Array<Int>(2,{0})
     var i = 0
     //var f = s[i]//5
     //var f2 = s[i+1]
    while(i<s.length-1){//for(i in 0..s.length-1){
      var j = i
      while(s[j]==s[j+1]){
       
         j++
      }
       bw.write("${j} ${s[j].code} ${s[j+1]} \n")
      if (s[j].toInt()>0){ //1 
         arr[1]++
       }else if(s[j].toInt()<1){
         arr[0]++
       }
      i=j
      i++
    }
     bw.write("${arr[1]} ${arr[0]} \n")
    if( arr[0]==0 || arr[1]==0){
      bw.write("0")
    }else {
      bw.write(if(arr[0]>arr[1]) "${arr[1]}" else "${arr[0]}")
    }
    
    // for(i in 0..n-1){  //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임) 
    //   //answer += k/arr[n-1-i]
    //   //k%=arr[n-1-i]
    //   //bw.write("${arr[i]}\n")
    // }

    // bw.write("${answer}")

    bw.flush()
    bw.close()
  }


