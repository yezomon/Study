package main

import (
	"fmt"
	//"strconv"
)

// 1652
func main() {
	//fmt.Println("Hello, World!")
	var n int
	var s string
	fmt.Scanf("%d", &n)
	rooms := make([][]string, n)
	//fmt.Printf("%d\n", len(rooms))
//	fmt.Printf("%d\n", len(rooms[0]))

	//n1, n2 := 0 //가로세로
	for i := 0; i < len(rooms); i++ {
		fmt.Scanf("%s", &s)
    rooms[i] = make([]string, len(s))
     for j:=0; j<len(rooms); j++ {
       rooms[i][j] = string(s[j])
     }
    //fmt.Printf("%c %c",s[0],s[4])
	}
//  fmt.Printf("%+v\n",rooms)
  horizon := 0
  //가로
	for i:=0; i<len(rooms); i++{
    sequence:=0
    // fmt.Printf("r %d\n", len(rooms))
	  for j:=0; j<len(rooms[0]); j++ {
	    if rooms[i][j] == "."{
        sequence++
      }else if rooms[i][j] == "X" {
        if  2 <= sequence {
          horizon++
        }
        sequence=0
      } 
    //  fmt.Printf("%d seq:%d\n",j,sequence)
	  }
      if  2 <= sequence {
        horizon++
       // fmt.Printf("horizon %d\n",horizon)
      }
	  //fmt.Printf("%d",i)
	}
 // fmt.Printf("horz:%d\n",horizon)
  vertical := 0
  //세로
  for i:=0; i<len(rooms); i++{
    sequence:=0
   //  fmt.Printf("r %d\n", len(rooms))
    for j:=0; j<len(rooms[0]); j++ {
      if rooms[j][i] == "."{
        sequence++
      }else if rooms[j][i] == "X" {
        if  2 <= sequence {
          vertical++
        }
        sequence=0
      } 
     // fmt.Printf("%d seq:%d\n",j,sequence)
    }
      if  2 <= sequence {
        vertical++
       // fmt.Printf("vertical %d\n",vertical)
      }
    //fmt.Printf("%d",i)
  }
  // fmt.Printf("vt:%d\n",vertical)

  fmt.Printf("%d %d\n",horizon,vertical)
	//fmt.Printf("%d\n", numberOfComputer)
}
