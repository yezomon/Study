package main
//15989
import (
  "fmt"
  "bufio"
  "os"
)
//dynamic programming dp
func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  t:=0 //max 1000000
  fmt.Fscanln(reader,&t)
  nums:=make([]int,t)
  max:=0
  i:=1
  for i <= t{
    n:=0
    fmt.Fscanln(reader,&n)
    if n > max {
      max = n
    }
    nums[i-1]=n
    i++
  }
  //점화식 결과계산
  //num1,num2,num3:=0,0,0
  results:=make([]int,max)
  results[0]=1
  if max > 1 {
    results[1]=2
  }
  if max > 2 {
    results[2]=3
  }
  for j:=3;j<max;j++{
    results[j]=(j+1)/2+1+results[j-3]
  }

  for j,_:=range nums {
    fmt.Fprintln(writer, results[nums[j]-1]) //num4
  }
  //fmt.Fprintln(writer, i)
}