package main
//2751
import (
  "fmt"
  "sort"
  "bufio"
  "os"
)

func main() {
	//fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  n:=0 //max 1000000
  fmt.Fscanln(reader,&n)
  
  arr := make([]int, n)//최대 100만개짜리 int형 배열
  for i,_:=range arr{
    fmt.Fscanln(reader,&arr[i])
  }
  sort.Ints(arr)
  //fmt.Fprintln(writer, arr) //F빼먹었을때 이상하게 나오던데 뭘까? 
  for _,v:=range arr{
    fmt.Fprintln(writer,v)
  }
}
