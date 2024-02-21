package main

//2493
import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	//fmt.Println("Hello, World!")
    var reader *bufio.Reader = bufio.NewReader(os.Stdin)
    var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
  
  n:=0  // 탑의 수 N은 1 이상 500,000 이하
  fmt.Fscanln(reader,&n)
   // m:=make(map[string]int)
   m:=make([]int64,n) // N개의 탑들의 높이   
  //높이는 1 이상 100,000,000
  /*
    풀기전 : 
    개별 탑은 자신보다 높이가 같거나 큰게 외쪽에 하나라도 있는지 찾는것 
    최악의 경우 : 오름차순 정렬되있는 경우 N번째탑은 N-1개를 탐색해야..?
    n이 50만이면 최대 2500억..??? nlogn이라고 치면 
    슬라이딩 윈도우나 dp로 줄여서 푸는법없나..? 아니면 바이너리트리..?근데 트리는 해당값을 배열내에서 지역성을 반영하지못한다.. 탐색속도는 빠름.. 
    
    힌트시청 : 모노톤스택 활용
    자기 자신보다 큰 값만 찾으면 이전범위에서 찾으면 되기때문에 n만큼만 탐색하면 되...겠다..?
  */
  monotoneStack:=make([]int64,0)
  indexStack:=make([]int,0)
  for i:=0;i<n;i++{
    fmt.Fscan(reader,&m[i])
  }
  monotoneStack=append(monotoneStack,m[0])
  indexStack=append(indexStack,0)
  answer:=make([]int,n)
  answer[0]=0
 // i:=0
  for i,k:=range m{
    //fmt.Fprintln(writer,i,k,monotoneStack)
    if i < 1{
      answer[i]=-1
      continue
    }
    for len(monotoneStack)>0 && k >= monotoneStack[len(monotoneStack)-1] { //=
      monotoneStack=monotoneStack[:len(monotoneStack)-1] //pop
      indexStack=indexStack[:len(indexStack)-1] //pop
      //fmt.Fprintln(writer,"pop",monotoneStack,indexStack,i)
      if len(monotoneStack) == 0 {
        break
      }
    }
    if len(monotoneStack) == 0 {
      answer[i]=-1
    }else {
      answer[i]=indexStack[len(indexStack)-1]
    }
    monotoneStack = append(monotoneStack,k)
    indexStack=append(indexStack,i)
    //fmt.Fprintln(writer,answer,monotoneStack,indexStack)
  }
  
  for i,k:=range answer{
    fmt.Fprint(writer,k+1)
    if i < len(answer)-1 {
        fmt.Fprint(writer," ")
    }
  }
  //fmt.Fprintln(writer,answer)
  //fmt.Fprintln(writer,m,len(m))
}
