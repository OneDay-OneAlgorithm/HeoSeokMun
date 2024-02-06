package february;

import java.util.*;

class ProDeliveringAndCollecting {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = deliveries.length - 1;
        int p = pickups.length - 1;

        if(Arrays.stream(deliveries).sum() == 0 && Arrays.stream(pickups).sum() == 0){
            return 0;
        }

        while(true){
            int will = Math.max(d, p);
            int dSum = cap;
            for(; d>=0; d--){
                if(deliveries[d] > dSum){
                    deliveries[d] -= dSum;
                    break;
                } else {
                    dSum -= deliveries[d];
                    deliveries[d] = 0;
                }
            }

            int pSum = cap;
            for(; p>=0; p--){
                if(pickups[p] > pSum){
                    pickups[p] -= pSum;
                    break;
                } else {
                    pSum -= pickups[p];
                    pickups[p] = 0;
                }
            }

            answer += (will + 1) * 2;

            if(deliveries[0] == 0 && pickups[0] == 0 && d == -1 && p == -1){
                break;
            }
        }

        return answer;
    }
}
