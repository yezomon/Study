
func twoSum(nums []int, target int) []int {
    m:= make(map[int]int, len(nums))
    //(조건)배열 내에 정답이 하나만 존재한다
    var s []int
    for i, k := range nums{
        an:=(target - k)
 
        if _,ok:=m[an]; ok{
            s=append(s, m[an])
            s=append(s, i)
            return s
        }
        m[k] = i

    }
    for key,value := range m{
        fmt.Println("K:",key, "value:",value)
    }
    return s
}