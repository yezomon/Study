package main

import (
  "fmt"
  "bufio"
  "os"
)

// 10431
func main() {
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  var n int
  t:=1 //의문의 0처리
  fmt.Fscanln(reader,&n)
   arr := make([][]int,n)
  
  for i:=0;i<n;i++{
    arr[i] = make([]int,21)
    //fmt.Fscanf(reader, "%d", &t)
    for j:=0;j<21;j++{
      //inp, _ := reader.ReadString('\n')
      //fmt.Fprintln(writer,inp)
      // if j == 20 {
      //   fmt.Fscanln(reader,"%d",&arr[i][j])
      //   continue
      // }
      fmt.Fscanf(reader,"%d",&arr[i][j])
    }
    fmt.Fscanf(reader, "%d", &t) //입력줄 끝에 의문의 0이 이상하게 들어가길래 처리하기 위한 변수 
  }
  //n*21*21
  a:=0
  for i,_:= range arr{
    a=0
    for j:=2;j<21;j++ {
      h := 1
      for h < j {
        if arr[i][h] > arr[i][j] {
           //arr[i][j],arr[i][h] = arr[i][h],arr[i][j]
          //17 19 20 18
          l:=j
          tmp:=arr[i][j]
           for l>h {
             arr[i][l] = arr[i][l-1] 
             l--
           }
          arr[i][h] = tmp
          //fmt.Fprintln(writer, h,j,arr[i])
           a+=(j-h)
           //a+=(20-h) //배열을 안밀고 해결하려 했는데 진짜로 밀어야하나?? ->진짜밀어야함. 
           break
         }
        h++
      }
    }
    fmt.Fprintln(writer,i+1,a)
  }
  //fmt.Fscanln(reader, &operator, &num)
  //fmt.Fprintln(writer, strPool)
}