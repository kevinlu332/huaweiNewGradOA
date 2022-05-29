import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class topTriangle {

    private static void helper(int num){
        int start = 1;
        int colInc = 2;
        int rowStep = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<num; i++){
            int temp = start;
            int colStep  = 0;
            System.out.print(temp + " ");
            for(int j =1 ; j<num - i; j++){
                int newStart = start + colInc + colStep + rowStep;
                sb.append(newStart);
                sb.append(" ");
                colStep++;
                start = newStart;
            }
            rowStep++;
            System.out.println(sb.toString());
            sb = new StringBuilder();
            start = temp + rowStep;
        }
    }
//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            int a = Integer.parseInt(line);
//            helper(a);
//        }
//    }


}