package january;

import java.util.*;

public class ProSortingFilenames {

    static String[] gFiles = null;
    public String[] solution(String[] files) {
        String[] answer = files.clone();
        gFiles = files.clone();

        Arrays.sort(answer, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return sort(o1, o2);
            }
        });


        return answer;
    }

    public static int sort(String aO, String bO){
        String a = "", b ="";

        int i = 0;
        for(; i < aO.length() ; i++){
            if ('0' <= aO.charAt(i) && aO.charAt(i) <= '9'){
                break;
            }
            a = a + aO.charAt(i);
        }

        int j = 0;
        for(; j < bO.length() ; j++){
            if ('0' <= bO.charAt(j) && bO.charAt(j) <= '9'){
                break;
            }
            b = b + bO.charAt(j);
        }

        if(!a.toLowerCase().equals(b.toLowerCase())){
            return a.compareToIgnoreCase(b);
        }

        a="";
        b="";
        int k=0;
        for(; i < aO.length() && k <5 ; i++, k++){
            if ('0' <= aO.charAt(i) && aO.charAt(i) <= '9'){
                a = a + aO.charAt(i);
            } else{
                break;
            }
        }

        k=0;
        for(; j < bO.length() && k<5; j++, k++){
            if ('0' <= bO.charAt(j) && bO.charAt(j) <= '9'){
                b = b + bO.charAt(j);
            } else{
                break;
            }
        }

        if(Integer.parseInt(a) != Integer.parseInt(b)){
            return Integer.parseInt(a) - Integer.parseInt(b);
        }

        return List.of(gFiles).indexOf(aO) - List.of(gFiles).indexOf(bO);
    }
}
