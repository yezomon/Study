package main
// 11723
import (
  "fmt"
  "bufio"
  "os"
)

//Todo. 시간초과는 bufio로 해결했으나, 비트연산이나 다른 방식으로 시도할 필요가 있을듯 
func main() {
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  var n int
  var num int
  //fmt.Scanf("%d\n", &n)
  fmt.Fscanln(reader,&n)
  operator := ""
  ziphop := make([]int, 20)
  check:=0
  
  for i := 0; i < n; i++ {
    //fmt.Scanf("%s %d", &operator, &num)
    fmt.Fscanln(reader, &operator, &num)
    if operator == "add" {
      if ziphop[num-1] == 0 {
        ziphop[num-1] = 1
      }
    } else if operator == "check" {
      if ziphop[num-1] == 1 {
        check = 1 
        //fmt.Printf("%d\n",check)
        fmt.Fprintln(writer,check)
      }else {
         check = 0
         //fmt.Printf("%d\n",check)
        fmt.Fprintln(writer, check)
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
  //fmt.Printf("%s\n", operator)
}