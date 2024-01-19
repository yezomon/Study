/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 //Todo code를 더 정리할 수 있는지 고민해보기 
 func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 243
// 564 
// 999999
// 9999
//8999001
     answer := &ListNode{}
     carry := 0 
     var a *ListNode
     a = answer

    for e1,e2 := l1,l2 ; ; e1,e2 = e1.Next,e2.Next{
        if e1 == nil && e2 == nil {
            if carry > 0 {
                answer.Val = carry
                carry = 0
            }else{
                answer = nil
            }
            break
        }else if e1 == nil {
            answer.Val = e2.Val + carry
            e1 = &ListNode{}
            carry =0
        }else if e2 == nil {
            answer.Val = e1.Val + carry
            e2 = &ListNode{}
            carry = 0
        }else{
            answer.Val = e1.Val + e2.Val + carry
            carry = 0
        }
        fmt.Println(answer.Val)
        if answer.Val > 9 {
            carry = 1 
            answer.Val = answer.Val-10
        }
         if e1.Next == nil && e2.Next == nil && carry < 1{
            
            break
        }
        answer.Next = &ListNode{}
        fmt.Println(answer, e1,e2,carry)
        answer = answer.Next
    }

    return a
}