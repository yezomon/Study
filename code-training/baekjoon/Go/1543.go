package main
//1543
import (
	"bufio"
	"fmt"
	"os"
//	"sort"
	"strings"
)

func main() {
	//fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  
  //fmt package의 scan 함수들은 space를 변수 분리로 인식함.
  s1, _ := reader.ReadString('\n')
  s2, _ := reader.ReadString('\n')
  s1 = strings.TrimSuffix(s1, "\n")
  s2 = strings.TrimSuffix(s2, "\n")
  ///fmt.Fprintln(writer,s1)
  ///fmt.Fprintln(writer,s2)
  fmt.Fprint(writer,strings.Count(s1,s2))
  //반례 
  /*
  
  */
}