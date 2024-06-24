  import java.io.BufferedReader
  import java.io.BufferedWriter
  import java.io.InputStreamReader
  import java.io.OutputStreamWriter
  import java.util.*

  fun main() {
    // println("Hello world!")
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()//split(" ")
    //var coin:Array<Int> = arrayOf(25,10,5,1)
    //var answer : Int = Integer.MAX_VALUE 
    for(i in 0..n-1){
       var arr:Array<Int> = Array<Int>(4,{0})
      var c = br.readLine().toInt()
      //5의 최대갯수 n/5부터 0까지 
      var f = c//5
      while(f>=0){
        if (f >=25){
            arr[0]++
            f=f-25
          }else if (f>=10){
            arr[1]++
            f=f-10
          }else if (f>=5){
            arr[2]++
            f=f-5
          }else if (f>=1){
            arr[3]++
            f=f-1
          }else{
            break
          }
        }
      //bw.write("${arr.joinToString()}\n")
      for(j in 0..arr.size-1){
         bw.write("${arr[j]}")
         if(j!=arr.size-1){
           bw.write(" ")
         }
      }
      if(i!=n-1){
        bw.write("\n")
      }
      //arr[i] = c
    }
    bw.flush()
    bw.close()
  }
