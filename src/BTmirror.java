public class BTmirror {

    /*
    *       4                     4'
    *      /   \
    *      8    2              8'     2'
    * */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode   binaryTreeMirror(TreeNode t1){
        if(t1 == null){
            return null;
        }
        TreeNode newNode = new TreeNode(t1.val);
        newNode.left = binaryTreeMirror(t1.left);
        newNode.right = binaryTreeMirror(t1.right);
        return newNode;
    }

//    public static void main(String[] args){
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(8);
//        root.right = new TreeNode(2);
//        binaryTreeMirror(root);
//        System.out.println(root.val);
//        System.out.println(root.left.val);
//        System.out.println(root.right.val);
//    }

}
