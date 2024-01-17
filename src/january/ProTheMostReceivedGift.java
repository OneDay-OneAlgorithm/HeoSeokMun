package january;

import java.util.HashMap;
import java.util.Map;

public class ProTheMostReceivedGift {
    static Map<String, Integer> giftPoint = new HashMap<>();
    static Map<String, Integer> index = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] list = new int[50][50];

        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
            giftPoint.put(friends[i], 0);
        }

        for (String str : gifts) {
            String[] s = str.split(" ");
            int from = index.get(s[0]);
            int to = index.get(s[1]);
            giveGift(list, from, to);
            giftPoint.put(s[0], giftPoint.get(s[0]) + 1);
            giftPoint.put(s[1], giftPoint.get(s[1]) - 1);
        }

        for (int i = 0; i < friends.length; i++) {
            int temp = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (list[i][j] > 0) {
                    System.out.println("* " + i + " " + j);
                    temp++;
                } else if (list[i][j] == 0) {
                    if (giftPoint.get(friends[i]) > giftPoint.get(friends[j])) {
                        System.out.println(i + " " + j);
                        temp++;
                    }
                }
            }
            answer = Math.max(temp, answer);
        }

        return answer;
    }

    public static void giveGift(int[][] list, int from, int to) {
        list[to][from]--;
        list[from][to]++;
    }

}
