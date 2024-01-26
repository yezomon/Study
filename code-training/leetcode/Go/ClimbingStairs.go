//DP & Memoization 
//3 은 1+2
//4 2+3
//5는 3+4
//6은 4+5

func climbStairs(n int) int {
	answer := 2
	prev := 1
	pre2 := 0

   for i:=2;i<n+2;i++ {
	   fmt.Println(i,"i",prev,"/",answer)
	   answer = prev + pre2
	   pre2 = prev
	   prev = answer
   }
   return answer
}