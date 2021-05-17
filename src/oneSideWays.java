import java.util.HashSet;
import java.util.Set;

public class oneSideWays {
    /*
    *
    *
    * */


    public static int oneSideWaysCount(int[] counts){
        int[] grams = new int[]{1,2,3,5,10,20};
        int index = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        helper(grams, counts, index, sum, set);
        System.out.println(set);
        return set.size()-1;

    }
    private static void helper(int[] grams, int[] counts, int index, int sum, Set<Integer> set){
        if(index >= counts.length) return ;

        if(counts[index]==0){
            while(index < counts.length && counts[index] == 0){
                index++;
            }
        }

        if(index >= counts.length) return ;
        for(int i = 0; i <= counts[index]; i++){
            sum += grams[index] * i;
            counts[index] -= i ;
            set.add(sum);
            helper(grams, counts, index+1, sum, set);
            counts[index] += i ;
        }


    }
    public static void main(String[] args){
        int[] count = new int[]{1,0,1,1,0,0};
        int ans = oneSideWaysCount(count);
        System.out.println(ans);
    }


}
