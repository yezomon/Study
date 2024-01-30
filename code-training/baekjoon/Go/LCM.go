package main
//13241
import (
	"fmt"
)

func main() {
  var num1 int64
  var num2 int64
  fmt.Scanf("%d %d",&num1,&num2)
  n := GCD(num1,num2)
  fmt.Printf("%d\n",num1*num2/n)
}
//최대공약수, 최소공배수 
func GCD (a int64 , b int64 ) int64{
  var n int64
  var i int64
  for  i = 1 ; i <= a && i<= b ; i++ {
    if a % i == 0 && b % i==0 {
     // fmt.Println(i)
       n = i
      continue
    }
    //fmt.Println(n)
  }
  //fmt.Println("GCD",n)
  return n
}