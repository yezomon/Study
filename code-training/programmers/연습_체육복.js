function solution(n, lost, reserve) {
    var answer = 0;
    //lost 앞뒤번호에 reverse있나.&& 해당 reserve가 lost에 없나. 
    //둘다 빌릴수있으면 작은 번호에서 빌리는게 그리디적으로 많이 빌려주는거아닌가?
    //연속적으로 빌려주는 경우는..?
    let arr = []; // 각 학생 체육복 보유현황.0번은 무시
    for(var i =0; i<=n;i++){
        arr[i] = 1
    }
    arr[0] = 0
    for(var j =0; j<lost.length;j++){
        arr[lost[j]] -= 1
    }
    for(var j =0; j<reserve.length;j++){
        arr[reserve[j]] += 1
    }
    for(var i=1;i<=n;i++){ //아래 if 문 순서가 바뀌어서 큰쪽에서 먼저 빌리면 테케 5개 틀림. 최대값이 아닌듯 
        if(arr[i]==0){
            if(arr[i-1]>1){
                arr[i-1]--
                arr[i]++
                continue
            }
            if(arr[i+1]>1){
                arr[i+1]--
                arr[i]++
                continue
            }
        }
    }
    for(var i = 1;i<=n;i++){
         if(arr[i]>0){
             answer++
         }
    }
    console.log(arr)
    return answer;
}
/*
Parameters
n(int)	lost(int[])	reserve(int[])
5
[2, 4]
[1, 3, 5]
//
5
[2, 4]
[3]
//
3
[3]
[1]
//
5
[4, 2]
[3, 5]
Return
5
4
2
5
*/