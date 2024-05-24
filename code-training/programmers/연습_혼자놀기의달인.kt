class Solution {
    fun solution(cards: IntArray): Int {
        var answer: Int = 0
        var mtl : MutableList<Int> = mutableListOf<Int>()
        var counts : Array<Int> = Array<Int>(cards.size,{0})
        for(i in 0..cards.size-1){
            mtl.add(cards[i])
        }
        for(i in 0..cards.size-1){
            if(cards[i]==-1){
                continue
            }
            var j = i
            var count = 0
            while(cards[j]!=-1){
              count++
              var tmp = cards[j]
              cards[j] = -1
              j = tmp-1
            }
            counts[i] = count
        }
        counts.sortDescending()
        answer = counts[0]*counts[1]
        println(answer)
        return answer
    }
}