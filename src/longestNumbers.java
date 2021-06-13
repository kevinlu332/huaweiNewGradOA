import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestNumbers {
    private static void helper(String str){
        //longest length number,its length ; if length same, print all
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        int p1 = 0, p2 = 0;
        /*
        while(p2<arr.length){
            if(p2 is not digit) {p2++; p1 = p2}
            else{
                while(p2<arr.length && p2 is digit) p2++;

                if(p2-p1 > maxLength) {sb = new one; }
                else(p2-p1 < maxLength) { p1 = p2; continue;}
                sb.append(new String(arr, p1, p2-p1)); append(','); maxLength = p2-p1; p1 = p2;
            }
        }
        if(sb length = 0) sout(","+"0");
        else: sb.deleteLast(); sout(sb.toString() + ","+maxLength);
         */
        while(p2 < arr.length){
            if(!Character.isDigit(arr[p2])){
                p2++; p1 = p2;
            }else{
                while(p2 < arr.length && Character.isDigit(arr[p2])) p2++;
                if(p2 - p1 > maxLength) sb  = new StringBuilder();
                else if(p2 - p1 < maxLength) {
                    p1 = p2;
                    continue;
                }
                sb.append(new String(arr, p1, p2-p1));
                sb.append(",");
                maxLength = p2 - p1;
                p1 = p2;
            }
        }
        if(sb.length() == 0) System.out.println( "," + "0");
        else {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString() + "," + maxLength);
        }

    }


//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//
//            helper(line);
//        }
//    }
}
