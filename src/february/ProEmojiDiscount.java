package february;

class ProEmojiDiscount {

    static int[] discount = new int[]{10, 20, 30, 40};
    static int[][] u;
    static int[] e;
    static int gPlus = 0;
    static int money = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        u = users;
        e = emoticons;

        dfs(0, new int[emoticons.length]);
        System.out.println(gPlus);
        System.out.println(money);
        return new int[]{gPlus, money};
    }

    public void dfs(int n, int[] dis){
        if(n == e.length){
            calc(dis);
            return;
        }

        for(int i=0;i<4;i++){
            dis[n] = discount[i];
            dfs(n + 1, dis);
        }
    }

    public void calc(int[] dis){
        int[] price = new int[dis.length];

        for(int i=0;i<price.length;i++){
            price[i] = e[i] * (100 - dis[i]) / 100;
        }

        int plus = 0;
        int sum = 0;
        for(int[] i : u){
            int myDis = i[0];
            int myPrice = i[1];
            int max = 0;

            for(int j=0;j<dis.length;j++){
                if(dis[j] >= myDis){
                    max += price[j];
                }
            }

            if(max >= myPrice){
                plus++;
            } else{
                sum += max;
            }
        }

        if (plus > gPlus){
            gPlus = plus;
            money = sum;
        } else if(plus == gPlus){
            money = Math.max(sum, money);
        }
    }
}
