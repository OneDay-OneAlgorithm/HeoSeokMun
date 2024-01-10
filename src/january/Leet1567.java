package january;

import java.util.ArrayList;
import java.util.List;

class Leet1567 {

    static List<Integer> plus= new ArrayList<>();
    static List<Integer> minus= new ArrayList<>();
    public int getMaxLen(int[] nums) {
        int answer = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                minus.add(i);
            } else if(nums[i] == 0){
                answer = Math.max(operate(), answer);
            } else {
                plus.add(i);
            }
        }

        answer = Math.max(operate(), answer);

        plus.clear();
        minus.clear();
        return answer;
    }

    public static int operate(){
        int returnValue = 0;
        if(minus.size() % 2 == 0){
            if (minus.size() == 0 && plus.size() == 0){
                returnValue = 0;
            } else if (minus.size() == 0){
                returnValue = plus.size();
            } else if (plus.size() == 0 ){
                returnValue = minus.size();
            } else{
                int min = Math.min(plus.get(0), minus.get(0));
                int max = Math.max(plus.get(plus.size()-1), minus.get(minus.size()-1));
                returnValue =  max - min + 1;
            }
        } else {
            if(minus.size() == 1 && plus.size() == 0) {
                returnValue = 0;
            } else if (minus.size() == 1) {
                int m = minus.get(0);
                int p = plus.get(plus.size() - 1);
                if( p >= m + 1){
                    returnValue = p - m;
                }
                p = plus.get(0);
                if( p <= m - 1) {
                    returnValue = Math.max(returnValue, m - p);
                }
            } else if (plus.size() == 0){
                returnValue = minus.size() - 1;
            } else {
                int max = Math.max(plus.get(plus.size()-1), minus.get(minus.size()-1));
                int min = minus.get(0) + 1;
                int temp = max - min + 1;

                max = minus.get(minus.size() - 1) - 1;
                min = Math.min(plus.get(0), minus.get(0));
                returnValue = Math.max(temp, max - min +1);
            }
        }

        plus.clear();
        minus.clear();
        return returnValue;
    }
}
