//i=0 j=0123 -> i=0123 j=3
//i=1 j=0123 -> i=0123 j=2
//i=2 j=0123 -> i=0123 j=1
//0,0 -> 0.2 -> 2,2 -> 2,0
//j짝수 일때 len 4
//i=0
//i,j-> j,len-i-1 -> len-i-1,len-j-1 -> len-j-1,i ->// i,len-j-1
//0,0 -> 0,3  -> 3,3  -> 3,0 j=0
//0,1 -> 1,3 -> 3,2 -> 2,0 j=1
//0,2 -> 2,3 -> 3,1 -> 1,0 
//0,3 -> 3,3 -> 3,0 -> 0,0
//i=1
//1,0 -> 0,2 -> 2,3 -> 3,1 
//1,1-> 1,2 -> 2,2 -> 2,1
//1,2-> 2,2 -> 2.1 -> 1,1

//2,0-> -> -> 0,1
//2-> 0,0
//3->1,0
//4 -> 1,1
//5 -> 2,1
//6 ->2,2

//정사각 회전

func rotate(matrix [][]int)  {
    j_range := len(matrix)/2
    if len(matrix) % 2 == 1 {
        j_range = len(matrix)/2+1
    }
    fmt.Println(j_range)
    
    for i:=0 ; i<len(matrix)/2 ; i++ {
         for j:=0 ; j<j_range; j++ {
             x:=0
             tmp:=0
             tmp2:=0
             for x < 4{
                if x == 0 {
                 tmp = matrix[j][len(matrix)-i-1]
                 matrix[j][len(matrix)-i-1] = matrix[i][j]
                }else if x== 1 {
                  tmp2 = matrix[len(matrix)-i-1][len(matrix)-j-1]
                  matrix[len(matrix)-i-1][len(matrix)-j-1] = tmp
                }else if x== 2 {
                  tmp = matrix[len(matrix)-j-1][i]
                  matrix[len(matrix)-j-1][i] = tmp2
                } else if x== 3 {
                    matrix[i][j] = tmp
                }
                x++ 
                //fmt.Println(i,"/",j,"/",tmp,"/",tmp2,"//",matrix)
             }
        }
    }
}