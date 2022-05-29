import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2ndOAq2 {

    private static int helper(){
        return 0;
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int a = Integer.parseInt(line);
            String[] s = line.split(" ");
            String[] s2 = reader.readLine().split(" "); //read extra line
            System.out.print("/n");  // to a new line
            System.out.println(helper());
        }
    }



}