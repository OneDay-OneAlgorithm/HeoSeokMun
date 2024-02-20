package february;
import java.io.*;
import java.util.*;


public class Baek1018 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static char[] w = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    static char[] b = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();

            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                startW(i, j);
                startB(i, j);
            }
        }

        System.out.println(answer);
    } 

    static void startW(int y, int x){
        int l=0;       
        int sum = 0;
        for(int i=y; i< y+8;i++){
            int k=0;
            for(int j=x;j<x+8;j++){
                if(l % 2 == 0){
                    if(map[i][j] != w[k]){
                        sum++;
                    }
                } else {
                    if(map[i][j] != b[k]){
                        sum++;
                    }
                }
                k++;
            }
            l++;
        }

        answer = Math.min(sum, answer);

    }

    static void startB(int y, int x){
        int l=0;       
        int sum = 0;
        for(int i=y; i< y+8;i++){
            int k=0;
            for(int j=x;j<x+8;j++){
                if(l % 2 == 0){
                    if(map[i][j] != b[k]){
                        sum++;
                    }
                } else {
                    if(map[i][j] != w[k]){
                        sum++;
                    }
                }
                k++;
            }
            l++;
        }
        answer = Math.min(sum, answer);
    }
}
