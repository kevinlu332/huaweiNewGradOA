import java.util.HashSet;
import java.util.Set;

public class Q1 {

    //S,  全大写， 可空，全部不同的排列数


    //“ABA” --> 3
    //AABBCC  --> 90

    /*
       A B A
       p

       Set<Character>   A

            */



    public static void main(String[] args)  {
        Set<String> set = new HashSet<>();
        String s1 = "ABA";
        String s2 = "AABBCC";
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        findCount(charArr1, set,0);
        System.out.println("ans1 = " + set.size());

        set = new HashSet<>();
        findCount(charArr2, set, 0);
        System.out.println("ans2 = " + set.size());

    }

    private static void findCount(char[] arr,Set<String> set, int index){
        if(index == arr.length){
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            set.add(new String(arr));
            findCount(arr, set, index+1);
            //set.remove(new String(arr));
            swap(arr, i, index);
        }

    }
    private static void swap(char[] arr, int x, int y ){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}