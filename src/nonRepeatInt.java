import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class nonRepeatInt {

    private static int helper(char[] arr){
        reverse(arr);

        int endNext = removeDup(arr);
        return convertToInt(arr, endNext);
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            char[] arr = line.toCharArray();
            System.out.println(helper(arr));
        }
    }
    private static void reverse(char[] arr){
        int i = 0, j = arr.length -1;
        while(i<j){
            char t = arr[i];
             arr[i] = arr[j];
             arr[j] = t;
             i++; j--;
        }
    }
    private static int removeDup(char[] arr){
        /*
        *  [1,2,3,3,4]
        *           i
        *           e
        *  Set: 1 2 3 4
        * */
        Set<Character> set = new HashSet<>();
        int end = 0;
        for(int i = 0; i<arr.length; i++){
            char cur = arr[i];
            if(set.contains(cur)) continue;
            else{
                set.add(cur);
                arr[end] = arr[i];
                end++;
            }
        }
        return end;
    }
    private static  int convertToInt(char[] arr, int endNext){
        //[1 , 2,3,4]
        int total = 0;
        for(int i = 0; i<endNext; i++){
            total*=10;
            total += Character.getNumericValue(arr[i]);
        }
        return total;
    }



}