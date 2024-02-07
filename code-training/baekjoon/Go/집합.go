package main

import (
	"fmt"
	"strconv"
)
//1747
func main() {
	//fmt.Println("Hello, World!")
  var n int
  fmt.Scanf("%d", &n)
  //n은 1~1,000,000 만약 n이 1000,000일 경우 답은 이것보다 큰수 
  //worst case : n=1,000,000 , 소수찾는데 걸리는 시간도 n부터~.. 
  //소수 : n^2 팰린드롬 : 글자길이 m 
  if n == 1 {
    n = 2
    fmt.Printf("%d",n)
    return
  }
  for i:=n;i<1100000;i++{
    if isPalindrome(i)&&isPrime(i) {
      fmt.Printf("%d",i)
      return
    }
  }
  //fmt.Printf("%d\n", numberOfComputer)
}

func isPrime(num int) bool{
  for i:=2;i<=num/2;i++ {
    if num%i==0{
      return false
    }
  }
  return true
}

func isPalindrome(num int) bool {
  s:=strconv.Itoa(num)
  for i:=0;i<len(s)/2;i++{
    if s[i] != s[len(s)-i-1]{
      return false
    }
  }
  return true
}

	operator := ""
	ziphop := make([]int, 20)
 check:=0
	for i := 0; i < n; i++ {
		fmt.Scanf("%s %d\n", &operator, &num)
		if operator == "add" {
			if ziphop[num-1] == 0 {
        ziphop[num-1] = 1
			}
		} else if operator == "check" {
      if ziphop[num-1] == 1 {
        check = 1
         fmt.Printf("%d\n",check)
      }else {
        check = 0
         fmt.Printf("%d\n",check)
      }
		} else if operator == "remove" {
      if ziphop[num-1] == 1 {
        ziphop[num-1] = 0
      }
		} else if operator == "toggle" {
      if ziphop[num-1] == 1 {
        ziphop[num-1] = 0
      }else if ziphop[num-1] == 0 {
        ziphop[num-1] = 1
      }
		} else if operator == "all" {
      for j := 0; j < 20; j++ {
        ziphop[j] = 1
      }
		} else if operator == "empty" {
      for j := 0; j < 20; j++ {
        ziphop[j] = 0
      }
		}
	}
	//winnter := "SK"//CY
	//fmt.Printf("%s\n", operator)