package main

//20125
import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	//fmt.Println("Hello, World!")
    var reader *bufio.Reader = bufio.NewReader(os.Stdin)
    var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
  
    n:=0  //지불할 돈 
  fmt.Fscanln(reader,&n)
   // m:=make(map[string]int)
   m:=make([][]string,n)
  //fmt.Fprintln(writer,n)
  //심장의 위치와 팔, 다리, 허리의 길이
  head,armL,armR,waist,legL,legR:=0,0,0,0,0,0    //각각 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
 // headPosition:=make([][]int,1)
  //headPosition[0]=make([]int,2) 
  headX,headY := 0,0 //중심 위치는 headX+1 headY 
  for i:=0;i<n;i++{
      s:=""
    m[i] = make([]string,n)
     fmt.Fscanln(reader,&s)
    for j:=0;j<n;j++{
      
      m[i][j] = string(s[j])
    }
    if head==0 && strings.ContainsAny(s,"*"){
      head = 1
      headX = i
      headY = strings.Index(s,"*")
      continue
    }
  }
  //fmt.Fprintln(writer,m)
  fmt.Fprintln(writer,headX+2,headY+1)
  for j:=0;j<n;j++{
    //fmt.Fprintln(writer,m[headX+1][j],m[headX+1])
    if m[headX+1][j] == "*"{
      if j<headY{
          armL++
      }else if j>headY{
        armR++
      }
      }
    // }else if m[headX+1][j] == "_"{
    //   break
    // }
  }
  
  for j:=headX+2;j<n;j++{
    if m[j][headY] == "*"{
      waist++
    }else if m[j][headY] == "_"{
      break
    }
  }

  for j:=headX+2+waist;j<n;j++{
    //fmt.Fprintln(writer,m[j][headY],m[headX+2+waist])
    if m[j][headY-1] == "*"{
      legL++}
    // }else if m[j][headY] == "_"{
    //   break
    // }
  }
  
  for j:=headX+2+waist;j<n;j++{
    if m[j][headY+1] == "*"{
      legR++}
    // }else if m[j][headY] == "_"{
    //   break
    // }
  }
  fmt.Fprintln(writer,armL,armR,waist,legL,legR)
    //fmt.Fprintln(writer,m,len(m))
}