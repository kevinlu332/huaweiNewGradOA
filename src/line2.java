import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class line2 {
    int m , n;
    public line2(int m, int n){
        this.m = m;
        this.n =  n;
    }
    public static int staticHelper(int m, int n){
        if(m == 0 || n == 0) return 1;
        return staticHelper(m-1, n) + staticHelper(m, n-1);
    }

    public int helper(int m, int n){
        if(m == 0 || n == 0) return 1;
        return helper(m-1, n) + helper(m, n-1);
    }

//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//
//            String[] s = line.split(" ");
//            int m = Integer.parseInt(s[0]);
//            int n = Integer.parseInt(s[1]);
//            System.out.println(helper(m,n));
//        }
//    }

}
