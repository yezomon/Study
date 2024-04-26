//programmers 직사각형 좌표
class Solution {
    fun solution(v: Array<IntArray>): IntArray {
        var answer = intArrayOf(0,0)
        //BufferedReader br
        //println("Hello Kotlin")
        var x = -2
        var y = -2
        for(i in 0..v.size-1){
            for(j in 0..v.size-1){
                if(i==j){
                    continue
                }
                if(v[i][0] == v[j][0]){
                    x = -1
                    break
                }
                x=i
            }
            if(x>=0){
                break
            }
        }
        for(i in 0..v.size-1){
            for(j in 0..v.size-1){
                if(i==j){
                    continue
                }
                if(v[i][1] == v[j][1]){
                    y = -1
                    break
                }
                y=i
            }
            if(y>=0){
                break
            }
        }
       //println(x)
       //println(y)
       answer = intArrayOf(v[x][0],v[y][1])
        //println(v[x][0])
        //println(v[y][1])
        return answer
    }
}
