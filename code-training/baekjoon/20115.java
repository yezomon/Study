
import java.io.*;
import java.util.*;

// 20115
// 에너지 드링크 
public class Main {
  // static int[] dp;
  static int[] arr; // 연산수
  //static int[] arr2;
  static Integer[] arr3={};

  public static void main(String[] args) throws Exception {
    // Input & Output stream
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;
    // int num = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    //arr = new int[num];
    arr3 = new Integer[num];
    for (int i = 0; i < num; i++) {
      arr3[i]=(Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(arr3,Collections.reverseOrder()); //(a,b)->b-a);
    //Collections.reverse(Arrays.asList(arr));
    System.out.println(Arrays.toString(arr3));
    double answer = arr3[0];
    for(int i =1; i<num; i++){
      answer += (double) arr3[i]/2;
    }
     System.out.println(String.valueOf(answer));
    
    // close the buffer
    br.close();
    bw.close();
  }
}
