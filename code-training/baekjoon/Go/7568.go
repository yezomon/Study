package main
//7568
import (
	"fmt"
  "bufio"
  "os"
  //"sort"
)
//n명의 학생이 각 학생들과 자신의 덩치를 비교해서 나보다 큰 덩치갯수를 센다 
//나보다 큰덩치 갯수가 동일한 학생은 같은 등수인것으로 간주한다.
//덩치갯수 시 비교횟수 : n^2  등수 셀때 비교횟수 : n--> 등수셀때 필요없는것이 나보다 덩치큰놈 갯수+1 이 등수라는 조건을 뒤늦게 확인.. 
func main() {
	//fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  n:=0
  fmt.Fscanln(reader,&n)
  arr := make([][]int,n)
  
  for i:=0;i<n;i++ {
    arr[i] = make([]int,5)
    arr[i][0] = i+1
    fmt.Fscanln(reader,&arr[i][1],&arr[i][2]) //키 무게
  }
  //몸무게 키 둘다 커야 덩치가 큰것으로 처리
 //나보다 덩치큰 사람 갯수세기 
  for i,_:=range arr{
    for j:=0;j<n;j++{
      //fmt.Fprintln(writer,arr[i][0],arr[j][0],arr[i][1],arr[j][1])
      if arr[i][1] < arr[j][1] && arr[i][2] < arr[j][2] {
        //rank[i] = rank[i] + 1
        arr[i][3] = arr[i][3] + 1
      }
    }
  }
  /*
  //갯수 순 정렬 
  for i,_:=range arr{
    for j:=0;j<n;j++{
      //fmt.Fprintln(writer,arr[i][0],arr[j][0],arr[i][1],arr[j][1])
      if  arr[i][3] < arr[j][3] {
        arr[i][0],arr[j][0] = arr[j][0],arr[i][0]
        arr[i][1],arr[j][1] = arr[j][1],arr[i][1]
        arr[i][2],arr[j][2] = arr[j][2],arr[i][2]
        arr[i][3],arr[j][3] = arr[j][3],arr[i][3]
        arr[i][4],arr[j][4] = arr[j][4],arr[i][4]
      }
    }
  } 
  
  r:=1 
  //최종 등수정하기 
  //rank := make([]int,n)
  arr[0][4] = r
  for i:=1;i<n;i++{
    if arr[i][3] == arr[i-1][3]{
      arr[i][4] = r
    }else if r!= i{
      r=i+1
      arr[i][4] = r
    }else {
      r++
      arr[i][4] = r
    }
    //arr[i][3] = i+1   
  }
 fmt.Fprintln(writer,arr)
  //등번호 순 정렬 
  for i,_:=range arr{
    for j:=0;j<n;j++{
      //fmt.Fprintln(writer,arr[i][0],arr[j][0],arr[i][1],arr[j][1])
      if  arr[i][0] < arr[j][0] {
        arr[i][0],arr[j][0] = arr[j][0],arr[i][0]
        arr[i][1],arr[j][1] = arr[j][1],arr[i][1]
        arr[i][2],arr[j][2] = arr[j][2],arr[i][2]
        arr[i][3],arr[j][3] = arr[j][3],arr[i][3]
        arr[i][4],arr[j][4] = arr[j][4],arr[i][4]
      }
    }
  } 
  */
  
 // fmt.Fprintln(writer,arr)
  for i,_:=range arr{
    fmt.Fprintf(writer,"%d",arr[i][3]+1)
    if(i!=len(arr)-1){
        fmt.Fprintf(writer," ")
    }
  }
  
}
