package main

import (
	"fmt"
	"strconv"
)
//Todo. 메모리를 덜 사용할방법 
func main() {
  numberPool := make([]int, 10000)

  for i := 1 ;i <= 10000 ;i++{
    if numberPool[i-1] != 1 {
      numberPool[i-1] = -100
    }
    
    nums := strconv.Itoa(i)
    d := i
    for j,_ := range nums{
      d += int(nums[j]-'0')
    }
    
    if d < 10000 {
       numberPool[d] = 1
    }   
  }

  for j := 0 ;j < 10000 ; j++ {
    if numberPool[j] == -100 {
      if j != 0 {
        fmt.Printf("%d\n",j)
      }
    }
  }
}
