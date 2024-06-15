
import java.io.*;
import java.util.*;
//Todo. 리팩토링
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] score= {{1,0},{2,0},{3,0}};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i =0,j=0,k=0;k<answers.length;i++,j++,k++){
            // System.out.println(String.valueOf(i)+" "+String.valueOf(j));
            if(first[i]==answers[j]){
                score[0][1]++;
            }
            if(i==first.length-1){
                i=-1;
            }
            if(j==answers.length-1){
                j=-1;
            }
        }
        for(int i =0,j=0,k=0;k<answers.length;i++,j++,k++){
            if(second[i]==answers[j]){
                score[1][1]++;
            }
            if(i==second.length-1){
                i=-1;
            }
            if(j==answers.length-1){
                j=-1;
            }
        }
        for(int i =0,j=0,k=0;k<answers.length;i++,j++,k++){
            
            if(third[i]==answers[j]){
                score[2][1]++;
            }
             if(i==third.length-1){
                i=-1;
            }
            if(j==answers.length-1){
                j=-1;
            }
        }
        //Arrays.sort(score,(a,b)->Integer.compare(b[0][1],a[0][1]));
        Arrays.sort(score,(a,b)->{if(a[1]!=b[1]) return b[1]-a[1];
                else return a[0]-b[0];});
        System.out.println(String.valueOf(score[0][0])+" "+String.valueOf(score[0][1]));
        System.out.println(String.valueOf(score[1][0]+" "+String.valueOf(score[1][1])));
        int max = score[0][1];
        answer = Arrays.copyOf(answer,answer.length+1);
        answer[0] = score[0][0];
        if(max == score[1][1]){
            answer = Arrays.copyOf(answer,answer.length+1);
            answer[1] = score[1][0];
        }
        if(max == score[2][1]){
            answer = Arrays.copyOf(answer,answer.length+1);
            answer[2] = score[2][0];
        }
        Arrays.sort(answer);

        return answer;
    }
}