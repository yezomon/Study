function solution(s) {
    var answer = true;
    //지수 표기법엔 e가 들어감. https://school.programmers.co.kr/learn/courses/14743/lessons/118019
    
    for(var i =0;i<s.length;i++){
        if(isNaN(s[i])){
            answer = false;
        }
        if(s.length!=4&&s.length!=6){
            answer = false;
        }
        console.log(isNaN(s[i]))
    }
    return answer;
}