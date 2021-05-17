import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class trainStop {

    private static void helper(int[] arr, Deque<Integer> deque){
        List<Integer> ansList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        dfs(arr, deque, ansList, 0, set);
        print(set);
    }
    private static void dfs(int[] arr, Deque<Integer> deque, List<Integer> ansList, int index, Set<List<Integer>> set){
        if(arr.length == ansList.size()) {
            set.add(new ArrayList(ansList));
            return;
        }


            //kicking deque elements
        int size = deque.size();
        for(int i = 0; i<3; i++){
            if(index<arr.length && i == 0){ // in then out
                ansList.add(arr[index]);

                dfs(arr, deque, ansList, index + 1 , set);
                //if(!deque.isEmpty() ){
                    //int val = deque.getFirst();

                    //ansList.add(val);
                    ansList.remove(ansList.size() -1 );
                //}
               // index++;
            }
            else if(index < arr.length && i == 1){ // in and still
                //if(!deque.isEmpty()){
                    deque.offerFirst(arr[index]);
                    dfs(arr, deque, ansList, index + 1, set);
                    deque.removeFirst();
                //}

            }
            else if ( i==2 && !deque.isEmpty()){ // out only

                int val = deque.getFirst();
                deque.removeFirst();
                ansList.add(val);
                dfs(arr, deque, ansList, index , set); //
                ansList.remove(ansList.size() - 1);
                deque.offerFirst(val);
            }
        }

    }
    private static void print(Set<List<Integer>> set){
        List<List<Integer>> ll = new ArrayList<>(set);
        Collections.sort(ll, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int val1 = getCode(o1), val2 = getCode(o2);
                return Integer.compare(val1, val2);
            }
        });
        for(List<Integer> ansList: ll){
            for(int i = 0; i<ansList.size(); i++){
                System.out.print(ansList.get(i));
                if(i !=ansList.size()-1) System.out.print(" ");
            }
            System.out.println();
        }

    }
    private static int getCode(List<Integer> o1){
        int  ttl = 0;
        for(int x: o1) ttl = ttl*(10) + x;
        return ttl;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int a = Integer.parseInt(line);

            String[] s2 = reader.readLine().split(" "); //read extra line
            int[] arr = new int[s2.length];
            for(int i = 0; i<s2.length; i++){
                arr[i] = Integer.parseInt(s2[i]);
            }
            //int[] arr=  new int[]{1,2,3};
            Deque<Integer> deque = new ArrayDeque<>();
            helper(arr, deque);
        }
    }


}