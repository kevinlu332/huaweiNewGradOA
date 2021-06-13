import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class get24 {

    private static boolean helper(int[] arr, int index, List<char[]> signList){
        for(int i = index; i<arr.length; i++){
            intSwap(arr, i, index);
            if(addSignToArr(arr, signList)) return true;
            if(helper(arr, index+1, signList)) return true;
            intSwap(arr, i, index);
        }
        return false;
    }
    private static boolean addSignToArr(int[] arr, List<char[]> signList){
        for(int i = 0; i<signList.size(); i++){
            char[] signs = signList.get(i);
            int[] val = new int[]{arr[0]};
            for(int j =0; j < signs.length ; j++){
                if(signs[j] == '+') val[0] += arr[j+1];
                else if(signs[j] == '-') val[0] -= arr[j+1];
                else if(signs[j] == '*') val[0] *= arr[j+1];
                else if(val[0] % arr[j+1] == 0 && signs[j] == '/') val[0] /= arr[j+1];
                if(val[0] == 24) return true;
            }
        }
        return false;
    }


    private static void swap(char[] arr, int i, int j){
        char temp =  arr[i];
        arr[i] = arr[j];
         arr[j] = temp;
    }
    private static void intSwap(int[] arr, int i, int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void main(String[] args) throws IOException {
//        //read line by line:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        char[] signArr = new char[]{'+', '-', '*', '/'};
//        List<char[]> signList = new ArrayList<>();
//        getSignPerm( signArr, 0, signList);
//        while ((line = reader.readLine()) != null) {
//
//            String[] s = line.split(" ");
//            int[] arr = new int[s.length];
//            for(int i = 0; i<arr.length; i++) arr[i] = Integer.parseInt(s[i]);
//
//            System.out.println(helper(arr, 0, signList));
//        }
//    }
    private static void getSignPerm(char[] signArr, int index, List<char[]> signList){
        if(index >=4){
            signList.add(new char[]{signArr[0], signArr[1], signArr[2]});
            return ;
        }
        for(int i = index; i<signArr.length; i++){
            swap(signArr, i, index);
            getSignPerm(signArr, index+1, signList);
            swap(signArr, i , index);
        }
    }

}