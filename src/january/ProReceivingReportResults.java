package january;

import java.util.*;

public class ProReceivingReportResults {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<Set<Integer>> list = new ArrayList<>();
        int[] answer = new int[id_list.length];

        for(int i=0;i<id_list.length;i++){
            list.add(new HashSet<>());
        }

        List<String> id_array = Arrays.asList(id_list);

        for(String i : report){
            String[] s = i.split(" ");
            int a = id_array.indexOf(s[0]);
            int b = id_array.indexOf(s[1]);
            list.get(b).add(a);
        }

        for(int i = 0; i< id_list.length;i++){
            if(list.get(i).size() >= k){
                for(Integer j : list.get(i)){
                    answer[j] ++;
                }
            }
        }

        return answer;
    }
}
