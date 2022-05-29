public class mySingleton1 {
    static int m, n;
    private static mySingleton1 ourInstance = new mySingleton1(m, n);

    public static mySingleton1 getInstance() {
        return ourInstance;
    }

    private mySingleton1(int m , int n) {
        this.m = m;
        this.n = n;
    }
    public int calc(int m , int n){
        if(m==0 && n ==0) return 0;
        else return 1;
    }
}
