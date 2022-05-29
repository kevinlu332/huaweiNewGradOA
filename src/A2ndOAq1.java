import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A2ndOAq1 {

    private static int helper(List<Cell> list, int[] req){
        int count = 0;
        int strategyType = req[1];
        int cpuReq = req[2];
        int memReq = req[3];
        Collections.sort(list, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                int cpuCount1 = o1.cpuCount;
                int memSize1 = o1.memSize;
                int cpuCount2 = o2.cpuCount;
                int memSize2 = o2.memSize;
                if(cpuCount1 == cpuCount2 && memSize1 == memSize2){
                    return Integer.compare(o1.number, o2.number);
                }
                else if(strategyType == 1){
                    if(cpuCount1 != cpuCount2){
                        return Integer.compare(o1.cpuCount - cpuReq, o2.cpuCount - cpuReq);
                    }else {
                        return Integer.compare(o1.memSize - memReq, o2.memSize - memReq);
                    }
                }else{
                    if(memSize1 != memSize2){
                        return Integer.compare(o1.memSize - memReq, o2.memSize - memReq);
                    }else {

                        return Integer.compare(o1.cpuCount - cpuReq, o2.cpuCount - cpuReq);
                    }
                }
            }
        });
        int reqAmount = Math.min(req[0], list.size());
        System.out.print(reqAmount + " ");
        int[] last;
        if(list.size() < reqAmount) last = new int[list.size()];
        else last = new int[reqAmount];
        for(int i = 0; i < last.length; i++){
            last[i] = list.get(i).number;
        }
        Arrays.sort(last);
        for(int num : last) System.out.print(num +" ");

        return 0;
    }

    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = reader.readLine();
        int size = Integer.parseInt(line);
        Cell[] arr = new Cell[size]; ////////////////
        int[] arrTemp = new int[5];
        for(int i = 0; i < size; i ++){
            line = reader.readLine();
            String[] s = line.split(",");
            for(int j  = 0; j < 5; j++){
                arrTemp[j] = Integer.parseInt(s[j]);
            }
            arr[i] = new Cell(arrTemp[0], arrTemp[1], arrTemp[2], arrTemp[3], arrTemp[4]);
        }
        line = reader.readLine();
        String[] s = line.split(" ");
        int[] req = new int[s.length];
        for(int i = 0; i < req.length; i++){
            req[i] = Integer.parseInt(s[i]);
        }

        /////////
//        int size = 6;
//        Cell[] arr = new Cell[]{
//                new Cell(
//                        0,2,200,0,1), new Cell(
//                        1,4,330,2,1), new Cell(
//                        2,3,400,3,1), new Cell(
//                        3,3,310,1,1), new Cell(
//                        4,3,320,8,1), new Cell(
//                        5,3,330,0,1),
//
//        };
//
//
//        int[] req = new int[]{ 3, 2, 3, 300, 9, 2};
        //////////////



        List<Cell> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(req[4] !=9 && arr[i].cpuArch != req[4] ){
                continue;
            }else if(req[5]!=2 && arr[i].supportNP!=req[5]){
                continue;
            }else if(arr[i].cpuCount < req[2] || arr[i].memSize < req[3]){
                continue;
            }
            list.add(arr[i]);
        }
        if(list.size() == 0) {
            System.out.print(0);
            return;
        }
        helper(list, req);
    }

    static class Cell{
        int number, cpuCount, memSize, cpuArch, supportNP;
        public Cell(int number, int cpuCount, int memSize, int cpuArch, int supportNP){
            this.number = number;
            this.cpuCount = cpuCount;
            this.memSize = memSize;
             this.cpuArch = cpuArch;
             this.supportNP  = supportNP;
        }
    }

}