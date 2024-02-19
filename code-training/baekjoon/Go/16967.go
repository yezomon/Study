package main
//16967
import (
  "fmt"
  "bufio"
  "os"
  //"sort"
)

func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  h,w,x,y,b:=0,0,0,0,0 //
  fmt.Fscanln(reader,&h,&w, &x, &y)
  arrB := make([][]int, h+x)
  //겹치는 면적 : w*2 - (w+x)  와 h*2 - (h+y)
  width:=(h*2 - (h+x))
  height:=(w*2 - (w+y))
  //fmt.Fprintln(writer,"wh",width,height)
  //fmt.Fprintln(writer, (h*2 - (h+y)),(w*2 - (w+x)))
   arrA := make([][]int, h)
  for i:=0;i<(h+x);i++ {
    arrB[i] = make([]int, w+y)
    if i< h {
       arrA[i] = make([]int, w)
    }

    for j:=0;j<(w+y);j++ {
      fmt.Fscan(reader,&arrB[i][j])
      if arrB[i][j] != 0 && i<=(h-x)&&j<=(w-y){
        arrA[i][j] = arrB[i][j]
      }
      if arrB[i][j] != 0 && (i >= h || j>=w) {
        //fmt.Fprintln(writer,"A'",i,j,arrB[i][j])
        arrA[i-x][j-y] = arrB[i][j]
      }
    }
    fmt.Fscanln(reader,&b)
  }
  //Bi,j = Ai,j + Ai-X,j-Y
   //fmt.Fprintln(writer,arrA)
  for i:=x; i<x+width; i++ { 
    for j:=y; j<y+height ;j++ {
      arrA[i][j] = arrB[i][j] - arrA[i-x][j-y]
      //fmt.Fprintln(writer,i,j,arrB[i][j],arrA[i-x][j-y],arrA[i][j])
    }
  }

  //최종출력
  for i,_:=range arrA { 
    for j,k:=range arrA[i] {
      fmt.Fprint(writer,k)
      if j!=len(arrA[i])-1{
        fmt.Fprint(writer," ")
      }
    }
    fmt.Fprintln(writer,"")
  }
 // sort.Sort(Int64Slice(scoreList))
  //fmt.Fprintln(writer,arrB)
 // fmt.Fprintln(writer,arrA)
}