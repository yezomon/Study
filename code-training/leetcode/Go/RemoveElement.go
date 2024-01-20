func removeElement(nums []int, val int) int {
    answer := 0
    end := len(nums)-1
    for i,k := range nums{
        fmt.Println("i",i)
        if k == val{
        if end < i{
            break
        }
            answer++
            tmp := nums[end]
            for tmp == val {
                end--
                if end < i {break}
                tmp = nums[end]
                fmt.Println("end:",end) 
                answer++
            }
            
            if end < i {break}
            nums[i] = tmp
            nums[end] = k
            end-=1
            
            fmt.Println("end:",end) 
            fmt.Println("k:",nums)         
        }
    }
    fmt.Println("an:",answer)       
    return len(nums)-answer
}