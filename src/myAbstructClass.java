public abstract class myAbstructClass {

    String color = "red";
    int number =5;

    public abstract String getspecificColor();

    public String getColor(){
        return color;
    }
    public String getColor(String inputColor){
        return inputColor;
    }

    /*
    * good side of adding a function in abstruct class (instead of in an interface)
    * you can define the function with body in an  abstruct class
    * If in interface, all the impClass need to all/define the function.
    * */
    public void eat(){
        System.out.println("eat!");
    }

}
