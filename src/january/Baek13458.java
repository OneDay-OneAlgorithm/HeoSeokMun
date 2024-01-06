package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] a;
    static int b, c;
    static long answer = 0;


    public static void main(String[] args) throws IOException {
        init();

        for (int i : a) {
            int temp = i - b;
            answer++;
            if (temp > 0) {
                int cTemp = temp / c;
                answer += cTemp;
                if (temp % c != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
