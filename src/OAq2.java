import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OAq2 {

    private static int helper(int k, int[] arr){
        int count=  0;
        int[] preFixSum = new int[arr.length + 1];
        preFixSum[0] = 0;
        for(int i = 0; i<arr.length; i++){
            preFixSum[i+1] = preFixSum[i] + arr[i];
        }
        for(int i = 0; i < preFixSum.length - 1; i++){
            for(int j = i + 1; j < preFixSum.length; j++){
                int sum = preFixSum[j] - preFixSum[i];
                if(sum % k == 0) count++;
            }
        }
        return count;
    }

//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            String[] s = line.split(" ");
//            int k = Integer.parseInt(s[1]);
//
//            String[] s2 = reader.readLine().split(" "); //read extra line
//            int[] arr = new int[s2.length];
//            for(int i = 0; i< arr.length; i++){
//                arr[i] = Integer.parseInt(s2[i]);
//            }
//
//            System.out.println(helper(k, arr));
//        }
//    }


}