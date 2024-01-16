func removeDuplicates(nums []int) int {
    m:= make(map[int]int,len(nums))
    c:=len(nums)
    ix := 0
    for i,k := range nums{
        if _,ok:=m[k];ok{ //중복요소
            c--
        }else{
            m[k]=i
            nums[ix] = k
            ix++
           //해당값의 인덱스
            //fmt.Println(ix)
            //fmt.Println(m)
        }
    }
    return c
}