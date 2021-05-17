import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OAq3 {

    private static int helper(int[][] matrix){
        Set<Integer> set= new HashSet<>();
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        //create the map
        for(int i = 0; i < matrix.length; i++){
            if(!map.containsKey(i)) map.put(i, new ArrayList<>());
            for(int j = i+1; j < matrix[0].length; j++){

                if(matrix[i][j]==0) continue;
                //if(!map.containsKey(i)) map.put(i, new ArrayList<>());
               List<Integer> list = map.get(i);
               list.add(j);
               map.put(i, list);
               if(!map.containsKey(j)) map.put(j, new ArrayList<>());
               List<Integer> list1 = map.get(j);
               list1.add(i);
               map.put(j, list1);
            }
        }
        for(Integer node: map.keySet()) {
            if (set.contains(node)) continue;
            count++;
            dfs(node, map, set);
        }
        return count;
    }
    private static void dfs(Integer node, Map<Integer, List<Integer>> map, Set<Integer> set){
        if(set.contains(node)) return;
        set.add(node);
        List<Integer> list = map.get(node);
        for(int x: list){
            dfs(x, map, set);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] s = line.split(",");
//        String[] s = new String[]{"110", "110", "001"};
        int[][] matrix = new int[s.length][s[0].length()];
        for(int i = 0; i < s.length; i++){
            char[] arr = s[i].toCharArray();
            for(int j = 0; j < arr.length; j++){
                matrix[i][j] = arr[j] - '0';
            }
        }
        System.out.println(helper(matrix));

    }


}