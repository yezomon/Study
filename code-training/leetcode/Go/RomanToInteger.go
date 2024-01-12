func romanToInt(s string) int {
    //rn := strconv.Itoa(s)
    r:= []rune(s)

    var answer int
    //what 494 -> CD 400 XC 90 IV
    for j:= 0; j<len(s) ; j++{
        if r[j] == 'L' {
           answer += 50
           continue
        }
        if r[j] == 'D' {
           answer += 500
           continue
        }
        if r[j] == 'M' {
            answer += 1000
            continue
        }
        if r[j] == 'V' {
            answer += 5;
            continue
        }

        if r[j] == 'I' {
            if (j < len(r)-1) && r[j+1] == 'V' {
                j++;
                answer += 5-1
                continue
            }
            if (j < len(r)-1) && r[j+1] == 'X' {
                j++;
                answer += 10-1
                continue
            }else {
                answer += 1
                continue
            }
        }//1 sub 4 ,9 IV IX 

        if r[j] == 'X' {
            if (j < len(r)-1)&&(r[j+1] == 'L') {
                j++;
                answer += 50-10;
                continue
            }
            if (j < len(r)-1)&&(r[j+1] == 'C') {
                j++;
                answer += 100-10;
                continue
            }else{
                answer += 10
                continue
            }
        }//10 sub XL XC 

        if r[j] == 'C' {
            if (j < len(r)-1) && (r[j+1] == 'D') {
                j++;
                answer += 500-100
                continue
            }
            if (j < len(r)-1) && (r[j+1] == 'M') {
                j++;
                answer += 1000-100
                continue
            }else{
                answer += 100
                continue
            }
        }//100 sub CD CM

    }
    return answer
}