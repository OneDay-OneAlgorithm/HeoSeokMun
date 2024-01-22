package january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek1026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        init();

        long answer = 0;
        Integer[] bList = Arrays.stream(b).boxed().toArray(Integer[]::new);

        Arrays.sort(a);
        Arrays.sort(bList, Collections.reverseOrder());

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * bList[i];
        }

        System.out.println(answer);

    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

    }
}
