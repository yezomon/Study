class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] sub = s.split(" ",-1); //https://school.programmers.co.kr/learn/courses/14743/lessons/118645 공백으로 문자열 구분시, 문자열 끝부분 공백을 무시하지않고 나오게함
        for(int j=0;j<sub.length;j++){
            for(int i=0;i<sub[j].length();i++){
                String subsub = sub[j];
                if(i%2==0){
                    sb.append(Character.toUpperCase(subsub.charAt(i)));
                }else{
                    sb.append(Character.toLowerCase(subsub.charAt(i)));
                }
            }
            if(j<sub.length-1){
                sb.append(" ");
            }
        }
        answer = sb.toString();
        return answer;
    }
}