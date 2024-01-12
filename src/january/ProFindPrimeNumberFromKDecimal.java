package january;

import java.util.*;

class ProFindPrimeNumberFromKDecimal {
    public int solution(int n, int k) {
        int answer = 0;
        List<Long> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(n, k);

        for(char c : s.toCharArray()){
            if(c != '0'){
                sb.append(c);
            } else if(sb.length() > 0) {
                long a = Long.parseLong(sb.toString());
                if(a > 1){
                    list.add(a);
                }
                sb.setLength(0);
            }
        }

        if(sb.length() > 0) {
            long a = Long.parseLong(sb.toString());
            if(a > 1){
                list.add(a);
            }
        }
        
        /*
        if(list.isEmpty()){
            return 0;
        }
        
        int max = Collections.max(list);
        
        boolean[] num = new boolean[max + 1];
        for(int i = 2; i <= Math.sqrt(max) ; i++){
            for(int j=i+i; j<num.length;j+=i){
                num[j] = true;
            }
        }
        
        for(int i: list){
            if(!num[i]){
                answer++;
            }
        }
        */

        for(Long i : list){
            if (isPrime(i)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


}
