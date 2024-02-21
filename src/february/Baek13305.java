package february;

import java.util.*;
import java.io.*;

public class Baek13305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static long[] road;
    static long[] city;
    
    public static void main(String[] agrs) throws Exception{
        n = Integer.parseInt(br.readLine());
        road = new long[n-1];
        city = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        long start = city[0];
        long answer = 0;

        for(int i = 1;i<n;i++){
            answer += start * road[i - 1];
            if(start > city[i]){
                start = city[i];                
            } 
        }
        System.out.println(answer);
    }
}
