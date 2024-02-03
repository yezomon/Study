package main

import (
	"fmt"
  "slices"
)

func main() {
  var n int
  var m int
  fmt.Scanf("%d %d", &n,&m)
  arr := make([]int,n)
  for i,_:=range arr{
    arr[i] = i+1
  }
  for i:=0;i<m;i++{
    a,b:=0,0
    fmt.Scanf("%d %d", &a,&b)
    slices.Reverse(arr[a-1:b])
    //fmt.Printf("%+v\n",arr)
  }
  for i:=0;i<len(arr);i++{
    fmt.Printf("%d", arr[i])
    if(i!=len(arr)-1){
      fmt.Printf(" ")
    }
  }
}
