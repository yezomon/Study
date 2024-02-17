package main
//1205
import (
	"fmt"
  "bufio"
  "os"
  //"sort"
)
 type Int64Slice []int64

 func (s Int64Slice) Len() int {
   return len(s)
 }

 func (s Int64Slice) Less(i, j int) bool {
   return s[i] > s[j] // <
 }

 func (s Int64Slice) Swap(i, j int) {
   s[i], s[j] = s[j], s[i]
 }
func main() {
	//fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  //n,score,p:=0,0,0 //현재리스트갯수, 새점수, 리스트size  최대점수 20억 
  //리스트의 등수는 보통 위에서부터 몇 번째 있는 점수인지로 결정
  var score int64
  n,p:=0,0
  fmt.Fscanln(reader,&n,&score,&p)
  scoreList:=make([]int64,n)
  for i:=0;i<n;i++ {
    fmt.Fscan(reader,&scoreList[i]) 
  }
  //sort.Sort(Int64Slice(scoreList))
  bigger,same:=0,0
  for _,k:=range scoreList {
    if k > score {
      bigger++
    }else if k == score {
      same++
    }
  }
  if bigger+same >= p {
    fmt.Fprintln(writer,-1)  
  } else{
    fmt.Fprintln(writer,bigger+1)
  }
  
  //fmt.Println(scoreList)
}
