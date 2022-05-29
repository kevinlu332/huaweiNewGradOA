import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class listPracti {

    List<Integer> list;
    line2 line22 = new line2(0, 0);
    mySingleton1 sing1;
    myParentInterface interfaceImp1 = new myInterfaceImp();

    public static void main(String str[]) throws IOException {

        listPracti lp = new listPracti();
        lp.list = new ArrayList<>();
        lp.list.add(5);
        lp.list.add(45);
        System.out.println(lp.list.get(0));

        int ans = lp.line22.helper(2, 2);
        System.out.println(ans);
        int ans2 = line2.staticHelper(2, 2);
        System.out.println(ans2);

        lp.sing1 = mySingleton1.getInstance();
        int ans3 = lp.sing1.calc(1, 1);
        System.out.println(ans3);
        int ans4 = lp.sing1.calc(0, 0);
        System.out.println(ans4);

        String s1 = lp.interfaceImp1.bark(0);
        System.out.println(String.format("expect No bark, received %s.", s1));

        String s2 = lp.interfaceImp1.bark(1);
        System.out.println(String.format("expect BARK, received %s.", s2));

        myAbstructClass abstructClass1 = new myRealClass();
        String color1 = abstructClass1.getColor();
        String color2 = abstructClass1.getColor("blue");
        String color3 = abstructClass1.getspecificColor();
        System.out.println(String.format("expect red. received %s", color1));
        System.out.println(String.format("expect blue. received %s", color2));
        System.out.println(String.format("expect specialBlue. received %s", color3));

        String aa = MyEnumClass.class.getName();
        System.out.println("MyEnumClass.class.getName() is: " + aa);
        Boolean bb = MyEnumClass.class.isPrimitive();
        System.out.println("MyEnumClass.class.isPrimitive() is: " + bb);
        String enumLargeName = MyEnumClass.LARGE.name();
        System.out.println("enumLargeName is: " + enumLargeName);

        MyEnumClass[] enumArr = MyEnumClass.values();
        for (MyEnumClass size : enumArr) {
            System.out.println(size.name() + "'s ordinal is: " + size.ordinal());
        }


        System.out.println("Now having 1 second sleep...........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("waked up!");
        System.out.println();


        //try, catch, finally
        try (FileInputStream fs = new FileInputStream("D:/")) {
            return;
        }
        /*catch(FileNotFoundException e){
            System.out.println("get fileNotFound exception:");
            e.printStackTrace();
        }*/
        /*
        //This is method 1: write out the catch statement
        //We also have method 2: throw exception at the function caller
        catch(IOException e){
            System.out.println("get IO exception:");
            e.printStackTrace();
        }*/ finally {
            System.out.println("reached finally statement");
        }


    }
}
