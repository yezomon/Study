package main

import (
	"fmt"
	"strconv"
)
//Todo. 큰수가 들어올때 n1,n2,n3부분을 반복문으로 바꿔야. 
func main() {
	//fmt.Println("Hello, World!")
  var num int
  answer:=0
  fmt.Scanf("%d ",&num)
  i:=1
  if num < 100 {
    fmt.Printf("%d\n",num)
    return
  }
  
  for ;i<=num;i++ { //1~110 
     nums := strconv.Itoa(i)
   // for j,_:= range nums{ // 100 ~ 
      //fmt.Println(i)
      j:=0
      if (j+2)>=len(nums) {
        continue
      }
      if len(nums) < 3 {
        continue
      }
      n1 := int(nums[j]-'0')
      n2 := int(nums[j+1]-'0')
      n3 := int(nums[j+2]-'0')
      //fmt.Println(n1,n2,n3);
      if (n2-n1)==(n3-n2){
        answer++
      }
  }
  
  if  len(strconv.Itoa(i))> 2 { //3자리수 이상인 경우.
   answer += 99
  }else {
    answer += i
  }
  //fmt.Printf("%d\n",num)
  fmt.Printf("%d\n",answer)
}


