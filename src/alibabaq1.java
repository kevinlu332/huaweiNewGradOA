import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class alibabaq1 {

    private static float helper(int n){
        int count = 0;
        float sum = 0;
        for(int i = 1; i < n; i++){
            int part1 = i;
            int part2 = n - i;
            int rem = Math.abs(part2 - part1);
            if(rem >= 2){
                for(int j = 1; j < rem; j++){
                    int part3 = j;
                    int part4 = rem - j;
                    float subSum = Math.min(part1, part2) + Math.max(part3, part4);
                    double percent =  (double)(1.0/(rem - 1));
                    sum += subSum * percent;
                    //System.out.println(sum);
                }
                count++;
            }else{
                sum += Math.max(part1, part2);
                count++;
            }

        }

        return (sum / count);
    }


//
//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            int n = Integer.parseInt(line);
//
//            System.out.printf("%.4f", helper(n));
//        }
//    }


}