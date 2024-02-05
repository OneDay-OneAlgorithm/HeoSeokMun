package february;

import java.util.*;

class ProPrivacy {
    static Map<String, Integer> termMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms){
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }
        int[] answer = calc(today, privacies);
        return answer;
    }

    static int[] calc(String day, String[] privacies){
        List<Integer> list = new ArrayList<>();

        int i = 1;
        for(String privacy : privacies){
            String[] s = privacy.split(" ");
            String[] startDay = s[0].split("\\.");
            String[] toDay = day.split("\\.");

            Integer term = termMap.get(s[1]);

            if(calcDay(startDay, toDay, term)){
                list.add(i);
            }
            i++;
        }

        for(Integer k : list){
            System.out.println(k);
        }

        System.out.println("========");

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    static Boolean calcDay(String[] startDay, String[] toDay, Integer term){

        Integer year = Integer.parseInt(toDay[0]) - Integer.parseInt(startDay[0]);
        Integer month = Integer.parseInt(toDay[1]) + year * 12 - Integer.parseInt(startDay[1]);
        Integer day = Integer.parseInt(toDay[2]) + month * 28 - Integer.parseInt(startDay[2]);

        if (day >= term * 28) {
            return true;
        }

        return false;
    }
}
