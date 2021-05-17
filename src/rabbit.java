//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class rabbit {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        int max = 0;
//        while(in.hasNext() ){
//            int val = in.nextInt();
//            list.add(val);
//            max  = Math.max(max, val);
//        }
//        int[] dp = new int[max];
//        dp[0] = 1; dp[1] = 1;
//        for(int i = 2; i<dp.length; i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(dp[list.get(i)] -1);
//        }
//    }
//
//}