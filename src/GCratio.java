import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCratio {

    private static void helper(char[] arr, int wSize)
    {
        /* 0123456789
        *  AACTGTGCACGACCTGA
        *  s   e
        *  int ansStartIndex = 0
        *  int GCCount=0
        *  loop the first amount of wSize, also update GCCount
        *  loop from end = wSize-1 to < arr.length-1
        *       ///int origGCCount = GCCount;
        *       int start = end - wSize+1;
        *       if(arr[end+1] == G or C){GCCount++;}
        *       if(arr[start]==G or C): GCCount--;
        *       //if(GCCount > origGCCount) ansStartIndex = start+1;///////////////
        *  sout( new String(arr, ansStartIndex, wSize);
        * */
        int ansStartIndex = 0;
        int GCCount =0;
        for(int i = 0; i<wSize; i++){
            if(isGC(arr[i])) GCCount++;
        }
        int maxGCCount = GCCount;//////////////////
        for(int end = wSize-1; end < arr.length-1; end ++ ){

            int start = end - wSize + 1;
            if(isGC(arr[end+1]) ) GCCount++;
            if(isGC(arr[start])) GCCount--;

            if(GCCount > maxGCCount) ansStartIndex = start+1;////////////////
            maxGCCount = Math.max(maxGCCount, GCCount);
        }
        System.out.println(new String(arr, ansStartIndex, wSize));
    }
    private static boolean isGC(char c) {
        return c =='G' || c == 'C';
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = reader.readLine() ; {
            char[] arr = line.toCharArray();

            String line2 = reader.readLine();//read extra line
            int window = Integer.parseInt(line2);
            if(arr.length < window) System.out.println("");

            helper(arr, window);
        }
    }

}