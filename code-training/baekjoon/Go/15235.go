package main

//15235
import (
  "bufio"
  "fmt"
  "os"
  //	"slices"
)
//Todo. for문돌리는거말고 수학적으로 푸는법 
func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  n := 0 //학생수 
  fmt.Fscanln(reader, &n)
  arr := make([]int, n)
  answer:=make([]int,n)
  queue:=make([]int,0)
  for i, _ := range arr {
    queue = append(queue, i)
    fmt.Fscan(reader, &arr[i])
  }
  fmt.Fscanln(reader,"")
  t:=0
  for {
    //fmt.Fprintln(writer,arr,queue,answer,t)
    t++
    a:=queue[0]
    queue=queue[1:]
    arr[a]-=1
    answer[a]=t
    if arr[a]>0 {
      queue = append(queue, a)
    }
    if len(queue) == 0 {
      break
    }
  }

  for i,k := range answer {
    fmt.Fprint(writer,k)
    if i != len(answer)-1 {
      fmt.Fprint(writer," ")
    }
  }
}
