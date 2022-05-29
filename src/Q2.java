public class Q2 {


    //13   十进制int

    // 1101
    //15
    //D   十六进制

    private static final char[] bucket = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args)  {
        int num = 13;

        helper(num, 2);
        helper(num, 8);
        helper(num, 16);
    }
    private static void helper(int num , int div_num){
        int cur = num;
        StringBuilder  sb = new StringBuilder();
        while (cur != 0 ){
            int rem = cur % div_num;
            char temp = 'A';
            if(rem >= 10){
                int extra = rem - 10;
                temp = bucket[extra];
                sb.append(temp);
            }else{
                sb.append((char)(rem+'0'));
            }

            cur /= div_num;
        }
        System.out.println(num + "的"+ div_num + "进制是： " + sb.reverse().toString());

    }


}