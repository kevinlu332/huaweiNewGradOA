import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class get7 {

    private static void helper(int max, List<Integer> inputList){
        int[] ansArr  = new int[max+1];
        find7AnsList(ansArr, max);
        printMatchCount(inputList, ansArr);
    }
    private static void find7AnsList(int[] ansArr, int val){
        int prev = 0;
        for(int i = 7; i<=val; i++){
            if(i % 7 == 0 || contains7(i) ) {
                ansArr[i] = ++prev;
            }
            else ansArr[i] = prev;//////////////////
        }
    }
    private static boolean contains7(int val){
        while(val>=1){
            if (val % 10 == 7) return true;/////////////////
            val /= 10;
        }
        return false;
    }
    private static void printMatchCount(List<Integer> inputList, int[] ansArr){
        for(int x: inputList){
            System.out.println(ansArr[x]);
        }
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            int a = Integer.parseInt(line);
            max = Math.max(max, a);
            list.add(a);
        }
//        list.add(20);
//        max = 20;
        helper(max, list);
    }



}