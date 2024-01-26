package january;

import java.util.*;

class ProNPlus1CardGame {
    static int answer = 1;
    static int[] gCards;
    static int[] index;
    static int length;
    static int gCoin;
    static List<Integer> have = new ArrayList<>();

    public int solution(int coin, int[] cards) {
        gCards = cards;
        length = cards.length;
        gCoin = coin;

        index = new int[length + 1];

        for(int i=0;i<length;i++){
            index[cards[i]] = i;
        }

        for(int i=0;i<length/3;i++){
            have.add(cards[i]);
        }

        calc();
        return answer;
    }

    public static void calc() {
        for(int i=length/3;i<length;i+=2){
            have.add(gCards[i]);
            have.add(gCards[i+1]);

            boolean canGo = false;
            for(int j: have){
                if(index[length + 1 - j] > i+1){
                    continue;
                }

                int a = index[j];
                int b = index[length + 1 -j];

                if(a < length/3 && b < length/3){
                    ;
                } else if (a < length /3){
                    if(gCoin < 1){
                        continue;
                    }
                    gCoin--;
                } else if(b < length / 3){
                    if(gCoin < 1){
                        continue;
                    }
                    gCoin--;
                } else{
                    if(gCoin < 2){
                        continue;
                    }
                    gCoin-=2;
                }

                have.remove(Integer.valueOf(j));
                have.remove(Integer.valueOf(length + 1 -j));
                answer++;
                canGo=true;

                System.out.println(j + " " + (length + 1 - j) + " " + gCoin);
                break;
            }

            if(!canGo){
                return;
            }
        }

    }
}
