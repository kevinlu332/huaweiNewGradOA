import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topViewBinary {


      public static class TreeNode {
        public int key;
        public TreeNode left;
       public TreeNode right;
        public TreeNode(int key) {
          this.key = key;
        }
      }


        public static List<Integer> topView(TreeNode root) {
            // Write your solution here
            //Map< hd, Cell(node, vd);
    /*
      traverse the root,
          if(root==null    return;
          if(map not have hd), make one; if make has: if(map.get(hd).vd > vd ) map.put(hd, new Cell(root, vd));
            left, right
    */
            Map<Integer, Cell> map = new HashMap<>();
            helper(map, root, 0,0);
            List<Integer> list = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(Map.Entry<Integer, Cell> entry: map.entrySet()){
                min = Math.min(min, entry.getKey());
            }
            for(int i = 0; i < map.size(); i++){
                list.add(0);
            }
            for(Map.Entry<Integer, Cell> entry: map.entrySet()){
                list.set(entry.getKey() - min, entry.getValue().node.key);
            }
            return list;
        }
        private static void helper(Map<Integer, Cell> map, TreeNode root, int vd, int hd){
            if(root==null )return;
            if(!map.containsKey(hd)) map.put(hd, new Cell(root, vd));
            if(map.get(hd).vd > vd ) map.put(hd, new Cell(root, vd));
            helper(map, root.left, vd+1, hd-1);
            helper(map, root.right, vd+1, hd+1);
        }
        private static  class Cell{
            TreeNode node;
            Integer vd;
            Cell(TreeNode node, Integer vd){
                this. node = node;
                this.vd = vd;
            }
        }

    public static void main(String[] args){
          TreeNode root=  new TreeNode(1);
          root.left = new TreeNode(2);
          root.left.left = new TreeNode (4);
          root.right = new TreeNode(3);
          root.right.right = new TreeNode(7);
          topView(root);
    }

}
