public class myInterfaceImp implements  myInterface{

    @Override
    public String bark(int m) {
        if(m==0) return "m=0, no barking. ";
        else return "m!=0, BARK BARK!";
    }
}
