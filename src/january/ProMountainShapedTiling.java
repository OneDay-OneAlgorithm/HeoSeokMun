package january;

class ProMountainShapedTiling {
    static int[] array;
    static int[] gTops;

    public int solution(int n, int[] tops) {
        array = new int[2 * n + 2];

        gTops = tops;
        dp(n);

        return array[2*n + 1];
    }


    public static void dp(int n){
        array[0] = 1;
        array[1] = 1;
        for(int i=2; i<=2*n+1 ;i++){
            if(i%2 == 0){
                if(gTops[i/2 - 1] == 1){
                    array[i] = (array[i - 2] + 2*array[i - 1]) % 10007;
                } else{
                    array[i] = (array[i - 2] + array[i - 1]) % 10007;
                }
            } else{
                array[i] = (array[i - 2] + array[i - 1]) % 10007;
            }
        }
    }
}
